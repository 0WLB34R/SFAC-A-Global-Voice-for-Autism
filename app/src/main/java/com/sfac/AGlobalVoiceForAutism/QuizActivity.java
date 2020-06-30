package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sfac.AGlobalVoiceForAutism.R;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;
import com.sfac.AGlobalVoiceForAutism.model.Answers;
import com.sfac.AGlobalVoiceForAutism.model.Questions;
import com.sfac.AGlobalVoiceForAutism.model.Quiz;
import com.sfac.AGlobalVoiceForAutism.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity  extends AppCompatActivity {
    private static final String QUIZ = QuizActivity.class.getSimpleName();
    private Context context;
    private static final int FRAME_ID = 600;
    private  Quiz quiz;
    private int Score=0;
    private int incorrectScore=0;
    private ActivitiesItem aI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        context = this;
        WebView myWebView = new WebView(this);
        setContentView(myWebView);
        receiveValues();
        myWebView.loadUrl(VideoListSingleton.getURL(aI.getId()));
    }

    private void receiveValues() {
        Intent intent = getIntent();
        if (intent.hasExtra(Constants.INTENT_KEY_ACTIVITY)) {
            String userObj = intent.getStringExtra(Constants.INTENT_KEY_ACTIVITY);
            aI = new Gson().fromJson(userObj, ActivitiesItem.class);
        }
    }
}