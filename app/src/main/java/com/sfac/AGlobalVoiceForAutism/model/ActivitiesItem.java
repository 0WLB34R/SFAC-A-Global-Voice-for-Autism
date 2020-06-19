package com.sfac.AGlobalVoiceForAutism.model;

public class ActivitiesItem {
    private int id;
    private String Lessons;
    private int icon_video;

    public ActivitiesItem(int id,String Lessons, int icon_video) {
    this.id = id;
    this.Lessons = Lessons;
    this.icon_video = icon_video;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getIcon_video() { return icon_video; }

    public void setIcon_video(int icon_video) { this.icon_video = icon_video; }

    public String getLessons() { return Lessons; }

    public void setLessons(String lessons) { Lessons = lessons; }
}
