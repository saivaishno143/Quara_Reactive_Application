package com.Quara.QuaraApplication.Models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "likes")
public class Like {
    @Id
    private String id;

    private String targetId; // ID of the question or answer being liked

    private String targetType; // "question" or "answer"

    private Boolean isLike; // true for like, false for dislike

    @CreatedDate
    private LocalDateTime createdAt;
}
