package com.sfac.AGlobalVoiceForAutism.adapter;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sfac.AGlobalVoiceForAutism.R;

public class QuizViewHolder extends RecyclerView.ViewHolder {

    public TextView questionNumber;
    public TextView questionText;
    public RadioGroup radiogroup;
    public RadioButton radioButton1;
    public RadioButton radioButton2;
    public RadioButton radioButton3;
    public RadioButton radioButton4;


    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);
        this.questionNumber = itemView.findViewById(R.id.questionNumber);
        this.questionText = itemView.findViewById(R.id.questionText);
        this.radiogroup = itemView.findViewById(R.id.RadioGroup);
        this.radioButton1 = itemView.findViewById(R.id.RadioButton1);
        this.radioButton2 = itemView.findViewById(R.id.RadioButton2);
        this.radioButton3 = itemView.findViewById(R.id.RadioButton3);
        this.radioButton4 = itemView.findViewById(R.id.RadioButton4);
    }
}
