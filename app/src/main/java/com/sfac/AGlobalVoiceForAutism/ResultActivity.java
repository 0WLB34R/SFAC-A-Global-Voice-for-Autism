package com.sfac.AGlobalVoiceForAutism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Context context;
    private Button menuButton;
    private TextView notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        context = this;
        initViews();
        addEvents();
    }
    private void initViews(){
        notes = findViewById(R.id.score);
        menuButton = findViewById(R.id.button4);
    }
    private void addEvents(){
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoMenu = new Intent(context,VideoListActivity.class);
                startActivity(videoMenu);
            }
        });
    }
}
