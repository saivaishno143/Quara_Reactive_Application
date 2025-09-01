package com.Quara.QuaraApplication.Events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ViewCountEvent {
    private String targetId;//it refers to the id of the target object being viewed
    private String targetType;//it refers to which type eg answer, question, etc.
    private LocalDateTime localDateTime;
}
