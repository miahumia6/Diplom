package com.prep.library.service;

import com.prep.library.entity.questionnaire.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    void save(Question question);
    List<Question> findAll();
    Optional<Question> findById(long id);
}
