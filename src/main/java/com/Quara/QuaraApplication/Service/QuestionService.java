package com.Quara.QuaraApplication.Service;

import com.Quara.QuaraApplication.Adapter.QuestionAdapter;
import com.Quara.QuaraApplication.Dto.QuestionRequestDto;
import com.Quara.QuaraApplication.Dto.QuestionResponseDto;
import com.Quara.QuaraApplication.Models.Question;
import com.Quara.QuaraApplication.Repository.QuestionRepository;
import com.Quara.QuaraApplication.Utils.CursorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService{
    private final QuestionRepository questionRepository;

    @Override
    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDto questionRequestDto) {

        Question question=Question.builder().
                title(questionRequestDto.getTitle())
                .Content(questionRequestDto.getContent())
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();

        return questionRepository.save(question)
                .map(QuestionAdapter::QuestionModelToResponseDto)
                .doOnSuccess(response-> System.out.println("Question created successfully: " + response))
                .doOnError(error->System.out.println("Error creating question: " + error.getMessage()));


    }

    @Override
    public Mono<QuestionResponseDto> getQuestionById(String id) {
    return questionRepository.findById(id)
                .map(QuestionAdapter::QuestionModelToResponseDto)
                .doOnSuccess(response -> System.out.println("Question retrieved successfully: " + response))
                .doOnError(error -> System.out.println("Error retrieving question: " + error.getMessage()));

    }

    @Override
    public Mono<Void> deleteQuestionById(String id) {
    return questionRepository.deleteById(id)
                .doOnSuccess(success -> System.out.println("Question deleted successfully"))
                .doOnError(error->System.out.println("Error deleting question: " + error.getMessage()));
    }

    @Override
    public Flux<QuestionResponseDto> searchQuestions(String query, int offset, int page) {
        return questionRepository.findByTitleOrContentContainingIgnoreCase(query, PageRequest.of(offset, page))
                .map(QuestionAdapter::QuestionModelToResponseDto)
                .doOnError(error -> System.out.println("Error searching questions: " + error.getMessage()))
                .doOnComplete(() -> System.out.println("Search completed successfully"));
    }

    @Override
    public Flux<QuestionResponseDto> getAllQuestions(String cursor, int size) {
        Pageable pageable= PageRequest.of(0, size);

        if(!CursorUtils.isValidCursor(cursor)){
            return questionRepository.findTop10ByOrderByCreatedAtAsc()
                    .take(size)
                    .map(QuestionAdapter::QuestionModelToResponseDto)
                    .doOnError(error -> System.out.println("Error retrieving questions: " + error.getMessage()))
                    .doOnComplete(() -> System.out.println("All questions retrieved successfully"));
        }
        else{
            LocalDateTime cursorTimeStamp=CursorUtils.parseCursor(cursor);
            return questionRepository.findByCreatedAtGreaterThanOrderByCreatedAtAsc(cursorTimeStamp,pageable)
                    .map(QuestionAdapter::QuestionModelToResponseDto)
                    .doOnError(error -> System.out.println("Error retrieving questions: " + error.getMessage()))
                    .doOnComplete(() -> System.out.println("All questions retrieved successfully"));

        }
    }


}
