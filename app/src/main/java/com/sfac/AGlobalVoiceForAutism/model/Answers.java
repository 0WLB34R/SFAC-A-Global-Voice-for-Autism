package com.sfac.AGlobalVoiceForAutism.model;

public class Answers  {
    private String value;
    private  boolean valid;

    public Answers(String value, boolean valid) {
        this.value = value;
        this.valid = valid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
