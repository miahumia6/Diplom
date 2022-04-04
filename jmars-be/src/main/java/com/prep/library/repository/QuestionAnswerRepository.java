package com.prep.library.repository;

import com.prep.library.entity.questionnaire.QuestionAnswer;
import com.prep.library.entity.questionnaire.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
    @Query("from ques_ans \n" +
            "where questionnaire_id = ?1")
    List<QuestionAnswer> findByQuestionnaire_Id(long id);
}
