package com.sfac.AGlobalVoiceForAutism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton button;
    private ImageButton button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        button = findViewById(R.id.education_button);
        button2 = findViewById(R.id.community);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommunityActivity();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVideoListActivity();
            }
        });
    }
    public void openVideoListActivity(){
        Intent intent = new Intent(this, VideoListActivity.class);
        startActivity(intent);
    }
    public void openCommunityActivity(){
        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);
    }

}
