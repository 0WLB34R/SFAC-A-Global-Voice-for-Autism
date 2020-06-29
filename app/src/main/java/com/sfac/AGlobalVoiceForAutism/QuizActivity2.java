package com.sfac.AGlobalVoiceForAutism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sfac.AGlobalVoiceForAutism.adapter.QuizRecyclerViewAdapter;
import com.sfac.AGlobalVoiceForAutism.callBack.QuizCallBack;
import com.sfac.AGlobalVoiceForAutism.model.Questions2;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity2 extends AppCompatActivity {

     private Context context;
     private RecyclerView recyclerView;
     private QuizRecyclerViewAdapter adapter;
     private List<Questions2> questions = new ArrayList<>();
     private Button uploadButton;
     private int[] verified;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list_view);
        context =this;
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#161E50"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        initViews();
        addEvents();
        fillQuizList();
    }
    private void initViews(){
        recyclerView = findViewById(R.id.quizListView);
        adapter = new QuizRecyclerViewAdapter(context,questions);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        uploadButton = findViewById(R.id.SummitButton);
    }
    private void addEvents(){
        adapter.setCallBack(new QuizCallBack() {
            @Override
            public void onFirstOptionClicked(Questions2 task) {
                Log.e("OnFirstOptionClicked",task.getQuestionNumber()+"option1" );
                int num = Integer.parseInt(task.getQuestionNumber());
                verified[num] = 1;
                Toast.makeText(context, num +" "+1 ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSecondOptionClicked(Questions2 task) {
                Log.e("OnSecondOptionClicked",task.getQuestionNumber()+"option2");
                int num = Integer.parseInt(task.getQuestionNumber());
                verified[num] = 2;
                Toast.makeText(context, num +" "+2 ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onThirdOptionClicked(Questions2 task) {
               Log.e("OnThirdOptionClicked",task.getQuestionNumber()+"option3");
                int num = Integer.parseInt(task.getQuestionNumber());
                verified[num] = 3;
                Toast.makeText(context, num +" "+3 ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFourthOptionClicked(Questions2 task) {
                Log.e("OnFourthOptionClicked",task.getQuestionNumber()+"option4");
                int num = Integer.parseInt(task.getQuestionNumber());
                verified[num] = 4;
                Toast.makeText(context, num +" "+4 ,Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, verified.length,Toast.LENGTH_SHORT);
            }
        });
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tam = verified.length;
                Toast.makeText(context, tam,Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void fillQuizList(){
        questions.add(new Questions2(1,"How many is 2+2?","1",
                "5","8","3","4"));
        questions.add(new Questions2(2,"What color is the red car","2",
                "black","Green","Red","Orange"));
        questions.add(new Questions2(3,"In what year was the telephone invented?",
                "3","2000","1876","1450","1960"));
        questions.add(new Questions2(4, "How old is Queen Elizabeth?",
                "4", "90","15","65","70"));
        verified = new int[questions.size()+1];
    }
}
