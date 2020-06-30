package com.sfac.AGlobalVoiceForAutism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sfac.AGlobalVoiceForAutism.adapter.QuizRecyclerViewAdapter;
import com.sfac.AGlobalVoiceForAutism.callBack.QuizCallBack;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;
import com.sfac.AGlobalVoiceForAutism.model.Questions2;
import com.sfac.AGlobalVoiceForAutism.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity2 extends AppCompatActivity {

     private Context context;
     private RecyclerView recyclerView;
     private QuizRecyclerViewAdapter adapter;
     private List<Questions2> questions = new ArrayList<>();
     private Button uploadButton;
     private ActivitiesItem aI;
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
        receiveValues();
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
                if(validateAnswers()){
                    Intent result = new Intent(context, ResultActivity.class);
                    startActivity(result);
                }
            }
        });
    }
    private void receiveValues(){
        Intent intent = getIntent();
        if (intent.hasExtra(Constants.INTENT_KEY_QUIZ)) {
            String userObj = intent.getStringExtra(Constants.INTENT_KEY_QUIZ);
            aI = new Gson().fromJson(userObj, ActivitiesItem.class);
        }
        if(aI.getNum()== 1){
            fillQuizList1();
        }else if(aI.getNum()==2){
            fillQuizList2();
        }
    }
    private void fillQuizList1(){
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
    private void fillQuizList2(){
        questions.add(new Questions2(1,"Who was Alan Turing?","1",
                "A dancer","A theoretical computer scientist","A famous chef",
                "A famous Actor"));
        questions.add(new Questions2(2,"\n" +
                "What color is Napoleon's white horse?","2",
                "black","Grey","White","Pink"));
        questions.add(new Questions2(3,"Who is the founder of Apple?",
                "3","Steve Jobs","Steve Wozniak","BOTH",
                "None is correct"));
        questions.add(new Questions2(4, "Why she doesn't love me?",
                "4", "I don't Know","Because she loves another",
                "She is just your friend","Ask her"));
        questions.add(new Questions2(5,"Who was Jhon Von Neumann?","5",
                "A Tailor","An American President","A fishman","It was mathematical"));
        verified = new int[questions.size()+1];
    }
    private boolean validateAnswers(){
        for(int i = 1 ; i<verified.length ;i++) {
            if (verified[i] == 0) {
                Toast.makeText(context, "Please answer all the questions",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        }
       return true;
    }
}
