package com.prep.library.entity.questionnaire;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.prep.library.view.View;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "option_id")
    @JsonView(View.Internal.class)
    private long optionId;
    @JsonView(View.Internal.class)
    @Column(name= "option_answer")
    private String option_answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private Question question;

    public Option(String optionAnswer) {
        this.option_answer = optionAnswer;
    }

    public Option() {
    }

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public String getOption_answer() {
        return option_answer;
    }

    public void setOption_answer(String option_answer) {
        this.option_answer = option_answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
