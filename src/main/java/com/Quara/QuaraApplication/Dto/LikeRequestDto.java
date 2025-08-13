package com.Quara.QuaraApplication.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeRequestDto {
    @NotBlank(message = "Target ID cannot be blank")
    private String targetId;

    @NotBlank(message = "Target type cannot be blank")
    private String targetType; // e.g., "answer", "question"

    @NotBlank(message = "Like status cannot be blank")
    private Boolean isLike; // true for like, false for dislike
}
