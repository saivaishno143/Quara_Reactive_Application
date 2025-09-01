package com.Quara.QuaraApplication.Service;

import com.Quara.QuaraApplication.Models.Question;
import com.Quara.QuaraApplication.Models.QuestionElasticDocument;
import com.Quara.QuaraApplication.Repository.QuestionDocumentReposiroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionIndexService implements IQuestionIndexService{
    private final QuestionDocumentReposiroy questionDocumentReposiroy;

    @Override
    public void createQuestionIndex(Question question) {
        QuestionElasticDocument document=QuestionElasticDocument.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .build();
        questionDocumentReposiroy.save(document);
    }
}
