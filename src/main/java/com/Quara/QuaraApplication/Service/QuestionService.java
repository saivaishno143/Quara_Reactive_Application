package com.Quara.QuaraApplication.Service;

import com.Quara.QuaraApplication.Adapter.QuestionAdapter;
import com.Quara.QuaraApplication.Dto.QuestionRequestDto;
import com.Quara.QuaraApplication.Dto.QuestionResponseDto;
import com.Quara.QuaraApplication.Models.Question;
import com.Quara.QuaraApplication.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService{
    private final QuestionRepository questionRepository;

    @Override
    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDto questionRequestDto) {

        Question question=Question.builder().
                title(questionRequestDto.getTitle())
                .Content(questionRequestDto.getContent())
                .updatedAt(LocalDate.now())
                .createdAt(LocalDate.now())
                .build();

        return questionRepository.save(question)
                .map(QuestionAdapter::QuestionModelToResponseDto)
                .doOnSuccess(response-> System.out.println("Question created successfully: " + response))
                .doOnError(error->System.out.println("Error creating question: " + error.getMessage()));


    }
}
