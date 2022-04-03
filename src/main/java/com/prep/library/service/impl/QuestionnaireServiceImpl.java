package com.prep.library.service.impl;

import com.prep.library.entity.questionnaire.Answer;
import com.prep.library.entity.questionnaire.Question;
import com.prep.library.entity.questionnaire.QuestionAnswer;
import com.prep.library.entity.questionnaire.Questionnaire;
import com.prep.library.pojo.questionnaire.QuestionWithAnswer;
import com.prep.library.pojo.questionnaire.QuestionnaireResponse;
import com.prep.library.repository.QuestionnaireRepository;
import com.prep.library.service.AnswerService;
import com.prep.library.service.QuestionAnswerService;
import com.prep.library.service.QuestionService;
import com.prep.library.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    QuestionnaireRepository questionnaireRepository;
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionAnswerService questionAnswerService;
    @Autowired
    AnswerService answerService;

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

    @Transactional
    public QuestionnaireResponse findAllQuestionnaires() {
        QuestionnaireResponse questionnaireResponse = new QuestionnaireResponse();
        List<QuestionWithAnswer> questionWithAnswerList = new ArrayList<>();

        var questionnaireList = questionnaireRepository.findAll();

        for (Questionnaire questionnaire : questionnaireList) {
            var questionnaireId = questionnaire.getQuestionnaire_id();
            questionnaireResponse.setQuestionnaire_id(questionnaireId);

            var questionAnswerList = questionAnswerService.findByQuestionnaire_Id(questionnaireId);
            for (QuestionAnswer questionAnswer : questionAnswerList) {
                var question = questionAnswer.getQuestion();
                var answer = questionAnswer.getAnswer();
                questionWithAnswerList.add(new QuestionWithAnswer(question.getQuestion(), answer.getAnswer()));
            }
        }
        questionnaireResponse.setQuestionWithAnswerList(questionWithAnswerList);
        return questionnaireResponse;
    }
}
