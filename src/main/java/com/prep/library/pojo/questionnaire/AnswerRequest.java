package com.prep.library.pojo.questionnaire;

import java.util.List;

public class AnswerRequest {
    private long question_id;
    private List<String> answers;

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
