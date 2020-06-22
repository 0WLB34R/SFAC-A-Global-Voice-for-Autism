package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
        context = this;

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#466060"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        fillQuizStr();
        setContentView(render());

        addEvents();
    }
    private void addEvents(){

    }


    List<RadioButton>allButtons = new ArrayList<>();
    private View render(){
        RelativeLayout parentRelativeLayout = new RelativeLayout(context);
        parentRelativeLayout.setBackgroundColor(getResources().getColor(R.color.colorQuiz));

        LinearLayout frameLinearLayout = new LinearLayout(context);
        frameLinearLayout.setOrientation(LinearLayout.VERTICAL);



        frameLinearLayout.setId(FRAME_ID);
        frameLinearLayout.setBackgroundColor(getResources().getColor(R.color.coloQuestions));
        frameLinearLayout.setGravity(LinearLayout.TEXT_ALIGNMENT_CENTER);




        int dynamicId = 0;
        for (Questions questions: this.quiz.getQuestions()){
            TextView questionTextView = new TextView(context);
            questionTextView.setText(questions.getDescription());
            questionTextView.setTextSize(15);
            frameLinearLayout.addView(questionTextView);



            RadioGroup possibleAnswers = new RadioGroup(context);
            possibleAnswers.setOrientation(LinearLayout.VERTICAL);



            for(Answers  answers: questions.getAnswers()){
                RadioButton answersRadioButton = new RadioButton(context);
                answersRadioButton.setId(dynamicId);
                answersRadioButton.setText(answers.getValue());

                allButtons.add(answersRadioButton);

                //radioButtons.add(answersRadioButton);
                possibleAnswers.addView(answersRadioButton);
                dynamicId++;
            }

            possibleAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int id) {
                    Log.e("onCheckedChanged", "Id:" + id);
                    for(RadioButton radioButton: allButtons){
                        if(radioButton.getId()==id ) {
                            Log.e("onCheckedChanged", "Text: " + radioButton.getText());
                            if (id == 0 || id == 5 || id == 10 || id == 15) {

                                Score++;


                                String succeed = "The number of correct answers is \t " + Score + "\n you are winning:)";
                                Toast.makeText(getBaseContext(), succeed, Toast.LENGTH_LONG).show();
                            } else {
                                incorrectScore++;
                                String failed = "The number of wrong answers is \t " + incorrectScore + "\n you are failing:(";

                                Toast.makeText(getBaseContext(), failed, Toast.LENGTH_LONG).show();

                            }
                        }
                    }

                }
            });
            frameLinearLayout.addView(possibleAnswers);
        }



        parentRelativeLayout.addView(frameLinearLayout);
       // ScrollView scrollView = new ScrollView(context);
        //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //scrollView.setLayoutParams(layoutParams);

        //scrollView.addView(frameLinearLayout);
        return parentRelativeLayout;

    }
    private void fillQuizStr (){
        this.quiz =  new Quiz();
        List<Questions> questions = new ArrayList<>();
        Questions number_one = new Questions("What is Elmo's color? ");
        List<Answers>answersNumber_One = new ArrayList<>();
        answersNumber_One.add(new Answers("Red", true));
        answersNumber_One.add(new Answers("Green", false));
        answersNumber_One.add(new Answers("Yellow", false));
        answersNumber_One.add(new Answers("Blue", false));
        answersNumber_One.add(new Answers("Pink", false));



        number_one.setAnswers(answersNumber_One);
        questions.add(number_one);




        Questions number_two = new Questions("What game is Elmo playing? ");
        List<Answers>answersNumber_Two = new ArrayList<>();
        answersNumber_Two.add(new Answers("Soccer", true));
        answersNumber_Two.add(new Answers("Basketball", false));
        answersNumber_Two.add(new Answers("Tennis", false));
        answersNumber_Two.add(new Answers("Swimming", false));
        answersNumber_Two.add(new Answers("Running", false));

        number_two.setAnswers(answersNumber_Two);
        questions.add(number_two);

        Questions number_three = new Questions("Where is the game located? ");
        List<Answers>answersNumber_Three = new ArrayList<>();
        answersNumber_Three.add(new Answers("USA", true));
        answersNumber_Three.add(new Answers("Bolivia", false));
        answersNumber_Three.add(new Answers("China", false));
        answersNumber_Three.add(new Answers("Russia", false));
        answersNumber_Three.add(new Answers("Denmark", false));

        number_three.setAnswers(answersNumber_Three);
        questions.add(number_three);

      /*/ Questions number_four = new Questions("Who is Elmo's best friend ");
        List<Answers>answersNumber_Four = new ArrayList<>();
        answersNumber_Four.add(new Answers("Manolo", true));
        answersNumber_Four.add(new Answers("Pedro", false));
        answersNumber_Four.add(new Answers("Chris", false));
        answersNumber_Four.add(new Answers("Ken", false));
        answersNumber_Four.add(new Answers("Rodrigo", false));

        number_four.setAnswers(answersNumber_Four);
        questions.add(number_four);/*/

        quiz.setQuestions(questions);
    }
}