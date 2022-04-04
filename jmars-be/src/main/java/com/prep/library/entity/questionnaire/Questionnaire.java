package com.prep.library.entity.questionnaire;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.prep.library.entity.User;
import com.prep.library.view.View;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="questionnaire")
public class Questionnaire {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private long questionnaire_id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonView(View.Public.class)
    private User user;

    @JsonView(View.Public.class)
    @OneToMany(mappedBy = "questionnaire", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<QuestionAnswer> questionAnswerList;

    public Questionnaire() {
    }


    public long getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(long questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Questionnaire(List<QuestionAnswer> questionAnswerList) {
        this.questionAnswerList = questionAnswerList;
    }

    public List<QuestionAnswer> getQuestionAnswerList() {
        return questionAnswerList;
    }

    public void setQuestionAnswerList(List<QuestionAnswer> questionAnswerList) {
        this.questionAnswerList = questionAnswerList;
    }
    public void addQuestionAnswerMap(QuestionAnswer questionAnswer){
        if(questionAnswerList == null){
            questionAnswerList = new ArrayList<>();
        }
        questionAnswerList.add(questionAnswer);
        questionAnswer.setQuestionnaire(this);
    }
}
