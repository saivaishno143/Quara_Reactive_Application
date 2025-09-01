package com.Quara.QuaraApplication.Service;

import com.Quara.QuaraApplication.Dto.QuestionRequestDto;
import com.Quara.QuaraApplication.Dto.QuestionResponseDto;
import com.Quara.QuaraApplication.Models.Question;
import com.Quara.QuaraApplication.Models.QuestionElasticDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;
import java.util.List;

public interface IQuestionService {

    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDto questionRequestDto);

    public Mono<QuestionResponseDto> getQuestionById(String id);

    public Mono<Void> deleteQuestionById(String id);

    public Flux<QuestionResponseDto> searchQuestions(String query, int offset, int page);

    public Flux<QuestionResponseDto> getAllQuestions(String cursor, int size);

    public List<QuestionElasticDocument> SearchQuestionByElastic(String query);
}
