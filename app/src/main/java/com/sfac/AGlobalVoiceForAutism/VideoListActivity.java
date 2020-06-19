package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.sfac.AGlobalVoiceForAutism.adapter.ActivitiesRecyclerViewAdapter;
import com.sfac.AGlobalVoiceForAutism.callBack.PlayVideoCallBack;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;
import com.sfac.AGlobalVoiceForAutism.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class VideoListActivity extends AppCompatActivity {
     private Context context;
     private RecyclerView taskRecyclerView;
     private ActivitiesRecyclerViewAdapter adapter;
     private List<ActivitiesItem> items = new ArrayList<>();

    @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_video_list);
     context = this;
     //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //getSupportActionBar().setTitle(R.string.edu_section);
     initviews();
     addEvents();
     fillvideoList();
 }
    private void initviews(){
        taskRecyclerView = findViewById(R.id.taskRecyclerView);
        adapter = new ActivitiesRecyclerViewAdapter(context, items);
        taskRecyclerView.setAdapter(adapter);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
    private void addEvents(){


        adapter.setCallBack(new PlayVideoCallBack() {
           @Override
           public void onTaskClicked(ActivitiesItem task) {
              Log.e("OnTaskClicked", task.getLessons()+"Play_video");
              Intent videoIntent = new Intent(context, Prueba.class);
              String videoString = new Gson().toJson(task);
              videoIntent.putExtra(Constants.INTENT_KEY_ACTIVITY, videoString);
              startActivity(videoIntent);
           }
       });
       //adapter.setCallBack(new PlayVideoCallBack() {
        //   @Override
         //  public void onTaskClicked(ActivitiesItem task) {
          //    Log.e("OnTaskClicked",task.getLessons()+"Quiz");
           //}
       //});
    }
    private void fillvideoList(){
       items.add(new ActivitiesItem("1","Video_1","dQw4w9WgXcQ",
               "Lesson #1",R.drawable.activities));
       items.add(new ActivitiesItem("2","Video_2","",
               "Lesson #2",R.drawable.worksheet));
       items.add(new ActivitiesItem("3","Video_3","",
               "Lesson #3",R.drawable.activities));
       items.add(new ActivitiesItem("4","Video_4","",
               "Lesson #4",R.drawable.worksheet));
       items.add(new ActivitiesItem("5","Video_5","",
               "Lesson #5",R.drawable.activities));
       items.add(new ActivitiesItem("6","Video_6","",
               "Lesson #6",R.drawable.worksheet));

    }
}
