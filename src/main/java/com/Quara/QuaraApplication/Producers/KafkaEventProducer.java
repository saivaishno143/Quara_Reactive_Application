package com.Quara.QuaraApplication.Producers;

import com.Quara.QuaraApplication.Config.KafkaConfig;
import com.Quara.QuaraApplication.Events.ViewCountEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaEventProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public void publishViewCountEvent(ViewCountEvent viewCountEvent) {
        kafkaTemplate.send(KafkaConfig.TOPIC_NAME,viewCountEvent.getTargetId(),viewCountEvent)
                .whenComplete((result,err)->{
                    if (err != null) {
                        System.out.println("Error while sending message to Kafka: " + err.getMessage());
                    }
                });

    }
}
