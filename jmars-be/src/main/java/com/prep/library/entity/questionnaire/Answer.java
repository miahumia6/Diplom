package com.prep.library.entity.questionnaire;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.prep.library.view.View;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    @Column(name = "answer_id")
    private long id;

    @JsonView(View.Public.class)
    @Column
    private String answer;

    public Answer() {
    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswers(String answer) {
        this.answer = answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
