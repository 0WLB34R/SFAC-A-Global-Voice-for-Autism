package com.sfac.AGlobalVoiceForAutism.model;

import java.util.List;

public class Questions {
    private String description;
    private List<Answers> answers;

    public Questions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
}
