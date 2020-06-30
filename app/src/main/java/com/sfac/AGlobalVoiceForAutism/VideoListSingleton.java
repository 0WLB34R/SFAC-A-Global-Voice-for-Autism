package com.sfac.AGlobalVoiceForAutism;

import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;

import java.util.ArrayList;

public class VideoListSingleton {
    private static VideoListSingleton instance = null;
    public int score = 0;
    public ArrayList<ActivitiesItem> activityItems=new ArrayList<ActivitiesItem>();;
    private VideoListSingleton(){
        score = 0; //score needs to be saved probably in database for unlocking stuff
        activityItems.add(new ActivitiesItem(2,"Hardcoded","lesson_one",
                ".jpg", "lesson # 1",R.drawable.activities));
        activityItems.add(new ActivitiesItem(0,"vSYadh2xmcI","ElmoLittle",
                ".jpg", "lesson # 2",R.drawable.elmo_1));
        activityItems.add(new ActivitiesItem(0,"MeO8VIx-jXA","Elmo",
                ".jpg", "lesson # 3",R.drawable.elmo_2));
        activityItems.add(new ActivitiesItem(0,"4","Video_4",
                ".jpg", "lesson # 4",R.drawable.worksheet));
        activityItems.add(new ActivitiesItem(0,"5","Video_5",
                ".jpg", "lesson # 5",R.drawable.activities));
        activityItems.add(new ActivitiesItem(0,"6","Video_6",
                ".jpg", "lesson # 6",R.drawable.worksheet));

    }
    public static VideoListSingleton getInstance(){
        if (instance == null)
            instance = new VideoListSingleton();

        return instance;
    }

    public static String getURL(String a){
        String url = "https://forms.gle/x6AmfJSij5YYbeCT6";
        switch (a){
            case "vSYadh2xmcI":
                url = "https://forms.gle/x6AmfJSij5YYbeCT6";
                break;
            case "MeO8VIx-jXA":
                url = "https://forms.gle/6ifG7FD5LTzYwWdy9";
                break;
            case "KcBmrnBmdzM":
                url ="https://forms.gle/x6AmfJSij5YYbeCT6";
        }
        return url;
    }


}


