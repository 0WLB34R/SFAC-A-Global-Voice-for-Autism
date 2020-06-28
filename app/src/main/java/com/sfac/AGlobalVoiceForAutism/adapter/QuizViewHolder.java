package com.sfac.AGlobalVoiceForAutism.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sfac.AGlobalVoiceForAutism.R;

public class QuizViewHolder extends RecyclerView.ViewHolder {

    public TextView questionNumber;
    public TextView questionText;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;


    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);
        this.questionNumber = itemView.findViewById(R.id.questionNumber);
        this.questionText = itemView.findViewById(R.id.questionText);
        this.button1 = itemView.findViewById(R.id.button1);
        this.button2 = itemView.findViewById(R.id.button2);
        this.button3 = itemView.findViewById(R.id.button3);
        this.button4 = itemView.findViewById(R.id.button4);
    }
}
