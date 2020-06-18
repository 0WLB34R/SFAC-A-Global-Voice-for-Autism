package com.sfac.AGlobalVoiceForAutism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoCommunity(View view){
        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);

    }
    public void gotoEducation(View view){
        Intent intent = new Intent(this, EducationActivity.class);
        startActivity(intent);

    }

}
