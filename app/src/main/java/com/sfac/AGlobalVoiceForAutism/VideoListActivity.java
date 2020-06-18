package com.sfac.AGlobalVoiceForAutism;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class VideoListActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_video_list_activities);
     getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     getSupportActionBar().setTitle(R.string.edu_section);
 }
}
