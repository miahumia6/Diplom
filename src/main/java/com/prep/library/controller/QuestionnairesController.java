package com.prep.library.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.prep.library.entity.questionnaire.Answer;
import com.prep.library.entity.questionnaire.Question;
import com.prep.library.entity.questionnaire.Questionnaire;
import com.prep.library.pojo.MessageResponse;
import com.prep.library.pojo.questionnaire.AnswerRequest;
import com.prep.library.pojo.questionnaire.QuestionnaireResponse;
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
public class QuestionnairesController {
    @Autowired
    QuestionnaireService questionnaireService;

    @JsonView(View.Public.class)
    @GetMapping("/questionnaires")
    public List<Questionnaire> getAllQuestionnaires() {
        return questionnaireService.findAll();
    }

    @GetMapping("/questionnaires/{id}")
    public Optional<Questionnaire> getQuestionnaireById(@PathVariable long id) {
        return questionnaireService.findById(id);
    }

    @PostMapping("/questionnaires")
    public ResponseEntity<?> createQuestionnaire(@RequestBody List<AnswerRequest> answerRequests) {

        Map<Question, Answer> questionAnswerMap = new HashMap<>();

        for(AnswerRequest answerRequest : answerRequests){
            for (String answer : answerRequest.getAnswers())
            {
                questionAnswerMap.put(new Question(answerRequest.getQuestion_id()), new Answer(answer));
            }
        }
        questionnaireService.save(questionAnswerMap);
        return ResponseEntity.ok(new MessageResponse("New Questionnaire added successfully!"));
        }
}