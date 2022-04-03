package com.prep.library.service;

import com.prep.library.entity.questionnaire.Answer;
import com.prep.library.entity.questionnaire.Question;
import com.prep.library.entity.questionnaire.Questionnaire;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface QuestionnaireService {
    void save(Questionnaire questionnaire);
    void save(Map<Question,Answer> questionAnswerMap);
    List<Questionnaire> findAll();
    Optional<Questionnaire> findById(long id);
}
