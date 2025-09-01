package com.Quara.QuaraApplication.Consumers;

import com.Quara.QuaraApplication.Config.KafkaConfig;
import com.Quara.QuaraApplication.Events.ViewCountEvent;
import com.Quara.QuaraApplication.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaEventConsumer {
    private final QuestionRepository questionRepository;

    @KafkaListener(
        topics = KafkaConfig.TOPIC_NAME,
        groupId = "view-count-group",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeViewCountEvent(ViewCountEvent viewCountEvent) {
        questionRepository.findById(viewCountEvent.getTargetId())
                .flatMap(question -> {
                    System.out.println("Incrementing view count for question ID: " + question.getId());
                    Integer views = question.getViews();
                    question.setViews(views==null?0:views+ 1);
                    return questionRepository.save(question);
                }).subscribe(updatedQuestion -> {
                    System.out.println("Updated view count for question ID: " + updatedQuestion.getId() + " to " + updatedQuestion.getViews());
                }, error -> {
                    System.out.println("Error updating view count: " + error.getMessage());
                });
    }

}
