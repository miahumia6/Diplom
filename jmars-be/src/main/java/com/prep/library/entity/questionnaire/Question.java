package com.prep.library.entity.questionnaire;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.prep.library.view.View;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "question_id")
    @JsonView(View.Public.class)
    private long question_id;

    @NotBlank
    @Size(max = 20)
    @JsonView(View.Public.class)
    private String question;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @JsonView(View.Internal.class)
    private List<Option> options;

    @JsonView(View.Internal.class)
    @Enumerated(EnumType.STRING)
    EType type;


    public Question(String question, List<Option> optionList, EType type) {
        this.question = question;
        this.options = optionList;
        this.type = type;
    }

    public Question() {
        }

    public Question(long question_id) {
        this.question_id = question_id;
    }


    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public void addOptions(Option option) {
        if (options == null) {
            options = new ArrayList<>();
        }
       options.add(option);
       option.setQuestion(this);
    }

}
