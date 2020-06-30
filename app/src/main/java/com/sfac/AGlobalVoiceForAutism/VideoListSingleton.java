package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;

import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;

import java.util.ArrayList;

public class VideoListSingleton {
    private static VideoListSingleton instance = null;
    public ArrayList<ActivitiesItem> activityItems=new ArrayList<ActivitiesItem>();
    private Context context;
    private String lesson = context.getString(R.string.lesson_section);

    private VideoListSingleton(){
        activityItems.add(new ActivitiesItem(1,"Hardcoded","lesson_one",
                ".jpg",  lesson+"# 1",R.drawable.activities));
        activityItems.add(new ActivitiesItem(2,"vSYadh2xmcI","ElmoLittle",
                ".jpg", lesson+"# 2",R.drawable.elmo_1));
        activityItems.add(new ActivitiesItem(3,"MeO8VIx-jXA","Elmo",
                ".jpg", lesson+"# 3",R.drawable.elmo_2));
        activityItems.add(new ActivitiesItem(4,"4","Video_4",
                ".jpg", lesson+"# 4",R.drawable.worksheet));
        activityItems.add(new ActivitiesItem(5,"5","Video_5",
                ".jpg", lesson+"# 5",R.drawable.activities));
        activityItems.add(new ActivitiesItem(6,"6","Video_6",
                ".jpg", lesson+"# 6",R.drawable.worksheet));
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


