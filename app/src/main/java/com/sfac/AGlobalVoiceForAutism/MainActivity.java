package com.sfac.AGlobalVoiceForAutism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sfac.AGlobalVoiceForAutism.activities.CommunityMainActivity;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private ImageButton button;
    private ImageButton button2;
    private ImageButton button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        context = this;
        initViews();
        addEvents();
    }
    private void initViews(){
        button = findViewById(R.id.education_button);
        button2 = findViewById(R.id.community);
        button3 = findViewById(R.id.about_us_button);
    }
    private void addEvents (){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEducation = new Intent(context, VideoListActivity.class);
                startActivity(intentEducation);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCommunityRegistration = new Intent(context, CommunityMainActivity.class);
                startActivity(intentCommunityRegistration);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbout_Us = new Intent(context,AboutUsActivity.class);
                startActivity(intentAbout_Us);
            }
        });
    }

}
