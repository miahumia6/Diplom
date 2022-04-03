package com.prep.library.service.impl;

import com.prep.library.entity.questionnaire.Answer;
import com.prep.library.entity.questionnaire.Question;
import com.prep.library.entity.questionnaire.QuestionAnswer;
import com.prep.library.entity.questionnaire.Questionnaire;
import com.prep.library.repository.QuestionRepository;
import com.prep.library.repository.QuestionnaireRepository;
import com.prep.library.service.QuestionService;
import com.prep.library.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    QuestionnaireRepository questionnaireRepository;
    @Autowired
    QuestionService questionService;

    @Override
    public void save(Questionnaire questionnaire) {
        questionnaireRepository.save(questionnaire);
    }

    @Override
    public List<Questionnaire> findAll() {
        return questionnaireRepository.findAll();
    }

    @Override
    public Optional<Questionnaire> findById(long id) {
        return questionnaireRepository.findById(id);
    }

    @Transactional
    public void save(Map<Question, Answer> questionAnswerMap) {
        Questionnaire questionnaire = new Questionnaire();
        for (Map.Entry<Question, Answer> entry : questionAnswerMap.entrySet()) {
            var question = questionService.findById(entry.getKey().getQuestion_id());
            if (question.isPresent()) {
                QuestionAnswer questionAnswer = new QuestionAnswer();
                questionAnswer.setQuestion(question.get());
                questionAnswer.setAnswer(entry.getValue());
                questionnaire.addQuestionAnswerMap(questionAnswer);
            }
        }
        questionnaireRepository.save(questionnaire);
    }
}
