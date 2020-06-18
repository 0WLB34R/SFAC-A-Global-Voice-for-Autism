package com.sfac.AGlobalVoiceForAutism;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class EducationActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_education);
     getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     getSupportActionBar().setTitle(R.string.edu_section);
 }
}
