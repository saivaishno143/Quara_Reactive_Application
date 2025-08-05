package com.Quara.QuaraApplication.Service;

import com.Quara.QuaraApplication.Dto.QuestionRequestDto;
import com.Quara.QuaraApplication.Dto.QuestionResponseDto;
import com.Quara.QuaraApplication.Models.Question;
import reactor.core.publisher.Mono;

public interface IQuestionService {

    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDto questionRequestDto);
}
