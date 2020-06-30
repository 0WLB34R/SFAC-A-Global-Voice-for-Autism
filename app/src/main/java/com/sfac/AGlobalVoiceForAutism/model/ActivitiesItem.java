package com.sfac.AGlobalVoiceForAutism.model;

import com.google.gson.annotations.Expose;

public class ActivitiesItem {
    @Expose
    private String id;

    @Expose
    private String extention;

    @Expose
    private String name;

    @Expose
    private int num;

    private int icon_video;
    private String Lessons;

    public ActivitiesItem(int num,String id,String name,String extention,String Lessons, int icon_video) {
    this.num = num;
    this.id = id;
    this.Lessons = Lessons;
    this.icon_video = icon_video;
    this.name = name;
    this.extention = extention;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public int getIcon_video() { return icon_video; }

    public void setIcon_video(int icon_video) { this.icon_video = icon_video; }

    public String getLessons() { return Lessons; }

    public void setLessons(String lessons) { Lessons = lessons; }

    public String getExtension() { return extention; }

    public void setExtention(String extention) { this.extention = extention; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getNum() { return num; }

    public void setNum(int num) { this.num = num; }
}
