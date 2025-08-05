package com.Quara.QuaraApplication.Adapter;

import com.Quara.QuaraApplication.Dto.QuestionResponseDto;
import com.Quara.QuaraApplication.Models.Question;

public class QuestionAdapter {

    public static QuestionResponseDto QuestionModelToResponseDto(Question question) {
        return QuestionResponseDto.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(question.getCreatedAt())
                .build();
    }
}
