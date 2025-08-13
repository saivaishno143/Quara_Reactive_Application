package com.Quara.QuaraApplication.Service;

import com.Quara.QuaraApplication.Dto.LikeResponseDto;
import reactor.core.publisher.Mono;

public interface ILikeService {
    Mono<LikeResponseDto> createLike(LikeResponseDto likeResponseDto);

    Mono<LikeResponseDto> countLikesByTargetIdAndTargetType(String targetId, String targetType);

    Mono<LikeResponseDto> countDislikesByTargetIdAndTargetType(String targetId, String targetType);

    Mono<LikeResponseDto> toggleLike(String targetId, String targetType, Boolean isLike);
}
