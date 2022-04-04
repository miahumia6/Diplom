package com.prep.library.service;

import com.prep.library.entity.questionnaire.Answer;
import com.prep.library.entity.questionnaire.Question;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    void save(Answer answer);
    List<Answer> findAll();
    Optional<Answer> findById(long id);
}
