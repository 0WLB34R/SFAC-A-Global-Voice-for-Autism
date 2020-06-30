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
    private int[] results;
    private int qNum;
    private int[] r1 ={0,4,3,2,1};
    private int []r2 ={0,2,3,3,2,4};
    private int AnswerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        context = this;
        initViews();
        addEvents();
        results = getIntent().getExtras().getIntArray("results");
        qNum =getIntent().getExtras().getInt("Quiz num");
        countResoult();
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
    private void countResoult(){
        if(qNum ==1){
            for(int j = 1 ;j<r1.length;j++){
                if(results[j]==r1[j]){
                    AnswerCount++;
                }
            }
        }else if(qNum==2){
            for(int j = 1 ;j<r2.length;j++){
                if(results[j]==r2[j]){
                    AnswerCount++;
                }
            }
        }
        int total = results.length-1;
        notes.setText(AnswerCount+ "/"+total);
    }
}
