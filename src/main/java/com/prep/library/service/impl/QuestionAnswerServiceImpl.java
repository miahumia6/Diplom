package com.prep.library.service.impl;

import com.prep.library.entity.questionnaire.QuestionAnswer;
import com.prep.library.repository.QuestionAnswerRepository;
import com.prep.library.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
    @Autowired
    QuestionAnswerRepository questionAnswerRepository;

    @Override
    public List<QuestionAnswer> findAll() {
        return questionAnswerRepository.findAll();
    }

    @Override
    public Optional<QuestionAnswer> findById(long id) {
        return questionAnswerRepository.findById(id);
    }

    @Override
    public List<QuestionAnswer> findByQuestionnaire_Id(long id) {
        return questionAnswerRepository.findByQuestionnaire_Id(id);
    }
}
