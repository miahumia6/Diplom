package com.prep.library.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.prep.library.entity.questionnaire.EType;
import com.prep.library.entity.questionnaire.Option;
import com.prep.library.entity.questionnaire.Question;
import com.prep.library.pojo.MessageResponse;
import com.prep.library.pojo.questionnaire.QuestionRequest;
import com.prep.library.service.QuestionService;
import com.prep.library.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class QuestionsController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/questions")
    @JsonView(View.Internal.class)
    public List<Question> getAllQuestions() {
        return questionService.findAll();
    }

    @GetMapping("/questions/{id}")
    public Optional<Question> getQuestionById(@PathVariable long id) {
        return questionService.findById(id);
    }

    @PostMapping("/questions")
    public ResponseEntity<?> addQuestion(@RequestBody QuestionRequest questionRequest) {
        var optionList = questionRequest.getOptionList().stream().map(Option::new).toList();


        Question question = new Question();
        question.setQuestion(questionRequest.getQuestion());
        optionList.forEach(question::addOptions);
        question.setType(EType.valueOf(questionRequest.getType()));
        // Question question = new Question(questionRequest.getQuestion(), optionList, EType.valueOf(questionRequest.getType()));
        questionService.save(question);
        return ResponseEntity.ok(new MessageResponse("New Question added successfully!"));
    }
}