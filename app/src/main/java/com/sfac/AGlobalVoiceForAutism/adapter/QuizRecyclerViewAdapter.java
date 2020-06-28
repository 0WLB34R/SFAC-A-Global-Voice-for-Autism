package com.sfac.AGlobalVoiceForAutism.adapter;

import android.content.Context;
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
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
       final Questions2 questions = this.questions.get(position);
       holder.questionText.setText(questions.getQuestionText());
       holder.questionNumber.setText(questions.getQuestionNumber());
       holder.radioButton1.setText(questions.getA1());
       holder.radioButton2.setText(questions.getA2());
       holder.radioButton3.setText(questions.getA3());
       holder.radioButton4.setText(questions.getA4());

    }



    @Override
    public int getItemCount() {
        return 0;
    }
}
