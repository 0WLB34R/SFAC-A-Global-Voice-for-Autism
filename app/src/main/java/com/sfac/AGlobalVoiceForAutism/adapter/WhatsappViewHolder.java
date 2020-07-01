package com.sfac.AGlobalVoiceForAutism.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfac.AGlobalVoiceForAutism.R;

public class WhatsappViewHolder extends RecyclerView.ViewHolder{
    public TextView title;
    public TextView description;
    public ImageView icon;

    public WhatsappViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.titleGroup);
        this.description = itemView.findViewById(R.id.decriptionGroup);
        this.icon=itemView.findViewById(R.id.whatsappIcon);
    }
}
