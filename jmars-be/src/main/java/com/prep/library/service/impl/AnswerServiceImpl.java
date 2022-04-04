package com.prep.library.service.impl;

import com.prep.library.entity.questionnaire.Answer;
import com.prep.library.entity.questionnaire.Question;
import com.prep.library.repository.AnswerRepository;
import com.prep.library.repository.QuestionRepository;
import com.prep.library.service.AnswerService;
import com.prep.library.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public void save(Answer question) {
        answerRepository.save(question);
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> findById(long id) {
        return answerRepository.findById(id);
    }
}
