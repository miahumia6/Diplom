package com.prep.library.service;

import com.prep.library.entity.questionnaire.Answer;
import com.prep.library.entity.questionnaire.Question;
import com.prep.library.entity.questionnaire.QuestionAnswer;
import com.prep.library.entity.questionnaire.Questionnaire;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface QuestionAnswerService {
    List<QuestionAnswer> findAll();
    Optional<QuestionAnswer> findById(long id);
    List<QuestionAnswer> findByQuestionnaire_Id(long id);

}
