package com.sfac.AGlobalVoiceForAutism.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sfac.AGlobalVoiceForAutism.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ActivitiesViewHolder extends RecyclerView.ViewHolder {
    public ImageView video_image;
    public TextView lesson;
    public Button link_videos;
    public Button link_quiz;


    public ActivitiesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.video_image = itemView.findViewById(R.id.iconImageView);
        this.lesson = itemView.findViewById(R.id.lesson);
        this.link_videos = itemView.findViewById(R.id.link_videos);
        this.link_quiz = itemView.findViewById(R.id.link_quiz);

    }
}
