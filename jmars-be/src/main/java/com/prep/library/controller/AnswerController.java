package com.prep.library.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.prep.library.entity.questionnaire.Answer;
import com.prep.library.entity.questionnaire.QuestionAnswer;
import com.prep.library.service.AnswerService;
import com.prep.library.service.QuestionAnswerService;
import com.prep.library.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @JsonView(View.Public.class)
    @GetMapping("/answers")
    public List<Answer> getAllAnswers() {
        return answerService.findAll();
    }

    @GetMapping("/answers/{id}")
    public Optional<Answer> getAnswerById(@PathVariable long id) {
        return answerService.findById(id);
    }

}