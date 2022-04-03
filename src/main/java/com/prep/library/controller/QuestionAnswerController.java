package com.prep.library.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.prep.library.entity.questionnaire.Answer;
import com.prep.library.entity.questionnaire.Question;
import com.prep.library.entity.questionnaire.QuestionAnswer;
import com.prep.library.entity.questionnaire.Questionnaire;
import com.prep.library.pojo.MessageResponse;
import com.prep.library.pojo.questionnaire.AnswerRequest;
import com.prep.library.service.QuestionAnswerService;
import com.prep.library.service.QuestionnaireService;
import com.prep.library.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class QuestionAnswerController {
    @Autowired
    QuestionAnswerService questionAnswerService;

    @JsonView(View.Public.class)
    @GetMapping("/questionAnswers")
    public List<QuestionAnswer> getAllQuestionnaires() {
        return questionAnswerService.findAll();
    }

    @GetMapping("/questionAnswers/{id}")
    public Optional<QuestionAnswer> getQuestionnaireById(@PathVariable long id) {
        return questionAnswerService.findById(id);
    }

}