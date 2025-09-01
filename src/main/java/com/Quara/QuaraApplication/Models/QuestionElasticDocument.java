package com.Quara.QuaraApplication.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "questions")
public class QuestionElasticDocument {
    private String id;
    private String title;
    private String content;

}
