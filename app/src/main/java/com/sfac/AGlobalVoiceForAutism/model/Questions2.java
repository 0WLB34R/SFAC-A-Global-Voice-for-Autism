package com.sfac.AGlobalVoiceForAutism.model;

import com.google.gson.annotations.Expose;

public class Questions2 {
    @Expose
    private String A1;

    @Expose
    private String A2;
    @Expose
    private String A3;

    @Expose
    private String A4;


    @Expose
    private int id;

    @Expose
    private String questionNumber;

    @Expose
    private String questionText;



    public Questions2(int id, String questionText, String questionNumber, String A1 ,
                      String A2, String A3, String A4, String A5){
        this.id= id;
        this.A1= A1;
        this.A2= A2;
        this.A3= A3;
        this.A4= A4;
        this.questionNumber= questionNumber;
        this.questionText =questionText;
    }

    public int getId(){return id;}

    public void setId(int ID){id= ID;}

    public String getA1() { return A1; }

    public void setA1(String a1) { A1 = a1; }

    public String getA2() { return A2; }

    public void setA2(String a2) { A2 = a2; }

    public String getA3() { return A3; }

    public void setA3(String a3) { A3 = a3; }

    public String getA4() { return A4; }

    public void setA4(String a4) { A4 = a4; }

    public String getQuestionNumber() { return questionNumber; }

    public void setQuestionNumber(String questionNumber) { this.questionNumber = questionNumber;
    }
    public String getQuestionText() { return questionText; }

    public void setQuestionText(String questionText) { this.questionText = questionText; }
}
