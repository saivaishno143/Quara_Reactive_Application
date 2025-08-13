package com.Quara.QuaraApplication.Service;

import com.Quara.QuaraApplication.Dto.AnswerRequestDto;
import com.Quara.QuaraApplication.Dto.AnswerResponseDto;
import reactor.core.publisher.Mono;

public interface IAnswerService {
    Mono<AnswerResponseDto> createAnswer(AnswerRequestDto answerRequestDto);

    Mono<AnswerResponseDto> getAnswerById(String id);
}
