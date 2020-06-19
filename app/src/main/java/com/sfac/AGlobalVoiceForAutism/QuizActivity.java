package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.sfac.AGlobalVoiceForAutism.R;

public class QuizActivity  extends AppCompatActivity {
    private static final String QUIZ = QuizActivity.class.getSimpleName();
    private Context context;

    private Button question1;
    private Button question2;
    private Button question3;
    private Button question4;

    private static final int FRAME_ID = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(render());

        addEvents();
    }
    private void addEvents(){

    }
    private View render(){
        RelativeLayout parentRelativeLayout = new RelativeLayout(context);
        parentRelativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

        LinearLayout frameLinearLayout = new LinearLayout(context);
        frameLinearLayout.setOrientation(LinearLayout.VERTICAL);
        frameLinearLayout.setId(FRAME_ID);
        frameLinearLayout.setBackgroundColor(getResources().getColor(android.R.color.white));

        RelativeLayout.LayoutParams frameLayoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        frameLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        frameLinearLayout.setLayoutParams(frameLayoutParams);

        LinearLayout.LayoutParams buttonsLayoutParams = new LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                25);
        question1  = new  Button (context);
        question1.setText(getString(R.string.question_1));
        question1.setLayoutParams(buttonsLayoutParams);
        question1.setBackgroundResource(R.color.colorPrimary);
        question1.setTextColor(getResources().getColor(android.R.color.black));
        frameLinearLayout.addView(question1);

        question2 = new Button(context);
        question2.setText(getString(R.string.quuestion_2));
        question2.setLayoutParams(buttonsLayoutParams);
        question2.setBackgroundResource(R.color.colorPrimary);
        question2.setTextColor(getResources().getColor(android.R.color.black));
        frameLinearLayout.addView(question2);

        parentRelativeLayout.addView(frameLinearLayout);
        return parentRelativeLayout;
    }
}