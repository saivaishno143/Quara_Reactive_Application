package com.Quara.QuaraApplication.Controller;

import com.Quara.QuaraApplication.Dto.QuestionRequestDto;
import com.Quara.QuaraApplication.Dto.QuestionResponseDto;
import com.Quara.QuaraApplication.Models.QuestionElasticDocument;
import com.Quara.QuaraApplication.Service.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final IQuestionService questionService;

    @PostMapping
    public Mono<QuestionResponseDto> createQuestion(@RequestBody QuestionRequestDto questionRequestDto) {
        return questionService.createQuestion(questionRequestDto)
                .doOnSuccess(response -> System.out.println("Question created successfully: " + response))
                .doOnError(error -> System.out.println("Error creating question: " + error.getMessage()));
    }

    @GetMapping("id/{id}")
    public Mono<QuestionResponseDto> getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(id)
                .doOnSuccess(response -> System.out.println("Question retrieved successfully: " + response))
                .doOnError(error -> System.out.println("Error retrieving question: " + error.getMessage()));
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteQuestionById(@PathVariable String id) {
        return questionService.deleteQuestionById(id)
                .doOnSuccess(response -> System.out.println("Question deleted successfully: " + response))
                .doOnError(error -> System.out.println("Error deleting question: " + error.getMessage()));
    }

    @GetMapping("/search")
    public Flux<QuestionResponseDto> searchQuestions(@RequestParam String query,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {

        return questionService.searchQuestions(query, page, size);

    }
    @GetMapping
    public Flux<QuestionResponseDto> getAllQuestions(@RequestParam(required = false) String cursor,
                                                     @RequestParam(defaultValue = "10") int size){
        return questionService.getAllQuestions(cursor, size)
                .doOnError(error -> System.out.println("Error retrieving questions: " + error.getMessage()))
                .doOnComplete(() -> System.out.println("All questions retrieved successfully"));
    }
    @GetMapping("/elasticsearch")
    List<QuestionElasticDocument> SearchQuestionByElastic(@RequestParam String query){
        return questionService.SearchQuestionByElastic(query);
    }
}
