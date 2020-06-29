package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
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

import com.sfac.AGlobalVoiceForAutism.R;
import com.sfac.AGlobalVoiceForAutism.model.Answers;
import com.sfac.AGlobalVoiceForAutism.model.Questions;
import com.sfac.AGlobalVoiceForAutism.model.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity  extends AppCompatActivity {
    private static final String QUIZ = QuizActivity.class.getSimpleName();
    private Context context;
    private static final int FRAME_ID = 600;
    private  Quiz quiz;
    private int Score=0;
    private int incorrectScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        context = this;
        WebView myWebView = new WebView(this);
        setContentView(myWebView);
        myWebView.loadUrl("https://forms.gle/6ifG7FD5LTzYwWdy9");
    }
}