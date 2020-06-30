package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

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
    private static final String LOG = VideoListActivity.class.getName();
    private Context context;
     private RecyclerView taskRecyclerView;
     private ActivitiesRecyclerViewAdapter adapter;
     private List<ActivitiesItem> items = new ArrayList<>();
     private Button extraVideo;
     private String lesson ;

     private static final String SHARED_PREF = "sharedPrefs";

     @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_video_list);
     context = this;
     lesson = getString(R.string.lesson_section);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#466060"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
     initviews();
     addEvents();
     fillvideoList();
 }
    private void initviews(){
        taskRecyclerView = findViewById(R.id.taskRecyclerView);
        adapter = new ActivitiesRecyclerViewAdapter(context, items);
        taskRecyclerView.setAdapter(adapter);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        extraVideo = findViewById(R.id.extra_video_button);
    }
    private void addEvents(){


        adapter.setCallBack(new PlayVideoCallBack() {
           @Override
           public void onTaskVideoClicked(ActivitiesItem task) {
              Log.e("OnTaskVideoClicked", task.getLessons()+"Play_video");
              Intent videoIntent;
              if(task.getId().equals("Hardcoded")){
                  videoIntent = new Intent(context, HardcodedVideoActivity.class);
                  saveState();
                  String videoString = new Gson().toJson(task);
                  videoIntent.putExtra(Constants.INTENT_KEY_ACTIVITY, videoString);
                  startActivity(videoIntent);
              }else if(loadData()){
                  videoIntent = new Intent(context, VideoActivity.class);
                  String videoString = new Gson().toJson(task);
                  videoIntent.putExtra(Constants.INTENT_KEY_ACTIVITY, videoString);
                  startActivity(videoIntent);
              }else{
                  Toast.makeText(context, "Videos Not Unlocked Yet!",
                          Toast.LENGTH_LONG).show();
              }
           }
           @Override
            public void onTaskQuizClicked(ActivitiesItem task) {
                Log.e("OnTaskClicked",task.getLessons()+"Quiz");
                Intent quizactivity;
                if(task.getId().equals("Hardcoded")){
                    quizactivity = new Intent(context, QuizActivity2.class);
                }else{
                    quizactivity = new Intent(context,QuizActivity.class);
                    String videoString = new Gson().toJson(task);
                    quizactivity.putExtra(Constants.INTENT_KEY_ACTIVITY, videoString);
                }
                String quizNumber = new Gson().toJson(task);
                quizactivity.putExtra(Constants.INTENT_KEY_QUIZ,quizNumber );
                startActivity(quizactivity);
            }
        });
        extraVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent extraintent = new Intent(context,PopUpVideoActivity.class);
                startActivity(extraintent);
            }
        });
    }
    private void fillvideoList() {
        for (ActivitiesItem item : VideoListSingleton.getInstance().activityItems){
            items.add(item);
        }

    }

    private void saveState(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("unlocked",true);
        editor.apply();
    }

    private boolean loadData(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        boolean unlocked = sp.getBoolean("unlocked",false);
        return unlocked;
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LOG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LOG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LOG, "onDestroy");
    }

}
