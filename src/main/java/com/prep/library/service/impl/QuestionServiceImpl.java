package com.prep.library.service.impl;

import com.prep.library.entity.questionnaire.Question;
import com.prep.library.repository.QuestionRepository;
import com.prep.library.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(long id) {
        return questionRepository.findById(id);
    }
}
