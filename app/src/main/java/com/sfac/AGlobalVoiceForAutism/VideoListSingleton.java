package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;

import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;

import java.util.ArrayList;

public class VideoListSingleton {
    private static VideoListSingleton instance = null;
    public ArrayList<ActivitiesItem> activityItems=new ArrayList<ActivitiesItem>();
    private Context context;

    private VideoListSingleton(Context c){ //Her goes hardcoded videos
        activityItems.add(new ActivitiesItem(1,"Hardcoded","lesson_one",
                ".jpg",  c.getString(R.string.lesson_section)+" 1",R.drawable.activities));
        activityItems.add(new ActivitiesItem(2,"Hardcoded","academicmaram1ar_matchboxlettersfinal",
                ".jpg",  c.getString(R.string.lesson_section)+" 2",R.drawable.activities));
        activityItems.add(new ActivitiesItem(3,"https://drive.google.com/file/d/1XECdttVGthdVUwT31sjYo1AaxHcj3oyt/view?usp=sharing","DivisionBoard",
                ".jpg", c.getString(R.string.lesson_section)+" 3",R.drawable.elmo_1));
        activityItems.add(new ActivitiesItem(4,"MeO8VIx-jXA","Elmo",
                ".jpg", c.getString(R.string.lesson_section)+" 4",R.drawable.elmo_2));
        activityItems.add(new ActivitiesItem(5,"5","Video_4",
                ".jpg", c.getString(R.string.lesson_section)+" 5",R.drawable.worksheet));
        activityItems.add(new ActivitiesItem(6,"6","Video_5",
                ".jpg", c.getString(R.string.lesson_section)+" 6",R.drawable.activities));
        activityItems.add(new ActivitiesItem(7,"7","Video_6",
                ".jpg", c.getString(R.string.lesson_section)+" 7",R.drawable.worksheet));
    }
    public static VideoListSingleton getInstance(Context c){
        if (instance == null)
            instance = new VideoListSingleton(c);

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


