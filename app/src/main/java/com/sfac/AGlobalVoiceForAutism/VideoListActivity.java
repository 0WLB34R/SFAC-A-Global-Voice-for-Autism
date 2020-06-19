package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sfac.AGlobalVoiceForAutism.adapter.ActivitiesRecyclerViewAdapter;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;

import java.util.ArrayList;
import java.util.List;

public class VideoListActivity extends AppCompatActivity {
     private Context context;
     private RecyclerView taskRecyclerView;
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
        ActivitiesRecyclerViewAdapter adapter = new ActivitiesRecyclerViewAdapter(context, items);
        taskRecyclerView.setAdapter(adapter);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
    private void addEvents(){

    }
    private void fillvideoList(){
       items.add(new ActivitiesItem(1,"Lesson #1",R.drawable.activities));
       items.add(new ActivitiesItem(1,"Lesson #2",R.drawable.worksheet));
       items.add(new ActivitiesItem(1,"Lesson #1",R.drawable.activities));
       items.add(new ActivitiesItem(1,"Lesson #2",R.drawable.worksheet));
       items.add(new ActivitiesItem(1,"Lesson #1",R.drawable.activities));
       items.add(new ActivitiesItem(1,"Lesson #2",R.drawable.worksheet));

    }
}
