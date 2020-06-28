package com.sfac.AGlobalVoiceForAutism.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sfac.AGlobalVoiceForAutism.callBack.QuizCallBack;
import com.sfac.AGlobalVoiceForAutism.model.Questions2;
import com.sfac.AGlobalVoiceForAutism.R;

import java.util.List;


public class QuizRecyclerViewAdapter extends RecyclerView.Adapter<QuizViewHolder> {
    private List<Questions2> questions;
    private LayoutInflater inflater;
    private QuizCallBack callback;

    public QuizRecyclerViewAdapter(Context context , List<Questions2> questions){
        this.questions = questions;
        this.inflater  = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = this.inflater.inflate(R.layout.activity_quiz_view, null);
        return new QuizViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuizViewHolder holder, int position) {
       final Questions2 question = this.questions.get(position);
       holder.questionText.setText(question.getQuestionText());
       holder.questionNumber.setText(question.getQuestionNumber());
       holder.button1.setText(question.getA1());
       holder.button2.setText(question.getA2());
       holder.button3.setText(question.getA3());
       holder.button4.setText(question.getA4());

       holder.button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(callback != null){
                   callback.onFirstOptionClicked(question);
                   holder.button1.setBackgroundResource(R.drawable.style_form_b);
               }
           }
       });
        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onSecondOptionClicked(question);
                }
            }
        });
        holder.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onThirdOptionClicked(question);
                }
            }
        });
        holder.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onFourthOptionClicked(question);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
    public void setCallBack(QuizCallBack callBack) {
        this.callback = callBack;
    }


}
