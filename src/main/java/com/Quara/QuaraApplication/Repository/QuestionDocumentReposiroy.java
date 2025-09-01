package com.Quara.QuaraApplication.Repository;

import com.Quara.QuaraApplication.Models.QuestionElasticDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionDocumentReposiroy extends ElasticsearchRepository<QuestionElasticDocument,String> {
    List<QuestionElasticDocument> findByTitleContainingOrContentContaining(String title, String content);
}
