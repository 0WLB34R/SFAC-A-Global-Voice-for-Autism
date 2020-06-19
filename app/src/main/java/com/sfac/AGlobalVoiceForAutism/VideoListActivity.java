package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sfac.AGlobalVoiceForAutism.adapter.ActivitiesRecyclerViewAdapter;
import com.sfac.AGlobalVoiceForAutism.callBack.PlayVideoCallBack;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;

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
           }
       });
       adapter.setCallBack(new PlayVideoCallBack() {
           @Override
           public void onTaskClicked(ActivitiesItem task) {
              Log.e("OnTaskClicked",task.getLessons()+"Quiz");
           }
       });
    }
    private void fillvideoList(){
       items.add(new ActivitiesItem(1,"Lesson #1",R.drawable.activities));
       items.add(new ActivitiesItem(2,"Lesson #2",R.drawable.worksheet));
       items.add(new ActivitiesItem(3,"Lesson #3",R.drawable.activities));
       items.add(new ActivitiesItem(4,"Lesson #4",R.drawable.worksheet));
       items.add(new ActivitiesItem(5,"Lesson #5",R.drawable.activities));
       items.add(new ActivitiesItem(6,"Lesson #6",R.drawable.worksheet));

    }
}
