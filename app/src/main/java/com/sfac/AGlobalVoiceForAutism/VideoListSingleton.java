package com.sfac.AGlobalVoiceForAutism;

import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;

import java.util.ArrayList;

public class VideoListSingleton {
    private static VideoListSingleton instance = null;
    public int score = 0;
    public ArrayList<ActivitiesItem> activityItems=new ArrayList<ActivitiesItem>();;
    private VideoListSingleton(){
        score = 0; //score needs to be saved probably in database for unlocking stuff
        activityItems.add(new ActivitiesItem("gMp0SlkVU8w","lesson_one",".jpg", "lesson # 1",R.drawable.elmo_1));
        activityItems.add(new ActivitiesItem("vSYadh2xmcI","ElmoLittle",".jpg", "lesson # 2",R.drawable.elmo_2));
        activityItems.add(new ActivitiesItem("MeO8VIx-jXA","Elmo",".jpg", "lesson # 3",R.drawable.activities));
        activityItems.add(new ActivitiesItem("4","Video_4",".jpg", "lesson # 4",R.drawable.worksheet));
        activityItems.add(new ActivitiesItem("5","Video_5",".jpg", "lesson # 5",R.drawable.activities));
        activityItems.add(new ActivitiesItem("6","Video_6",".jpg", "lesson # 6",R.drawable.worksheet));

    }
    public static VideoListSingleton getInstance(){
        if (instance == null)
            instance = new VideoListSingleton();

        return instance;
    }
}

