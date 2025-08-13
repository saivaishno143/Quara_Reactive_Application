package com.Quara.QuaraApplication.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerResponseDto {
    private String id;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
