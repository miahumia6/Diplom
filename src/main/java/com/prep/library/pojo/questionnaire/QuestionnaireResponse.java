package com.prep.library.pojo.questionnaire;

import java.util.List;

public class QuestionnaireResponse {
    private long questionnaire_id;
    private long user_id;
    private List<QuestionWithAnswer> questionWithAnswerList;

    public long getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(long questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public List<QuestionWithAnswer> getQuestionWithAnswerList() {
        return questionWithAnswerList;
    }

    public void setQuestionWithAnswerList(List<QuestionWithAnswer> questionWithAnswerList) {
        this.questionWithAnswerList = questionWithAnswerList;
    }
}
