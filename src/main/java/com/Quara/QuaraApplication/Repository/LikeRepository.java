package com.Quara.QuaraApplication.Repository;

import com.Quara.QuaraApplication.Models.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LikeRepository extends ReactiveMongoRepository<Answer,String> {

}
