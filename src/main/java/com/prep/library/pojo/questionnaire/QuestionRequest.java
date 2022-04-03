package com.prep.library.pojo.questionnaire;

import com.prep.library.entity.questionnaire.Option;

import java.util.List;

public class QuestionRequest {
    private String question;
    private String type;
    private List<String> optionList;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<String> optionList) {
        this.optionList = optionList;
    }
}
