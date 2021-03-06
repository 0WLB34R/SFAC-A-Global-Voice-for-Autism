package com.sfac.AGlobalVoiceForAutism.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfac.AGlobalVoiceForAutism.callBack.PlayVideoCallBack;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;
import com.sfac.AGlobalVoiceForAutism.R;

import java.util.List;


public class ActivitiesRecyclerViewAdapter extends RecyclerView.Adapter<ActivitiesViewHolder> {
   private List<ActivitiesItem> activitiesItems;
   private LayoutInflater inflater;
   private PlayVideoCallBack callBack;


    public ActivitiesRecyclerViewAdapter(Context context , List<ActivitiesItem> activitiesItems) {
        this.activitiesItems = activitiesItems;
        this.inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ActivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = this.inflater.inflate(R.layout.activity_video_list_activities,null);
        return new ActivitiesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivitiesViewHolder holder, int position) {
       final ActivitiesItem activitiesItem = this.activitiesItems.get(position);
       holder.video_image.setImageResource(activitiesItem.getIcon_video());
       holder.lesson.setText(activitiesItem.getLessons());

       holder.link_videos.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(callBack != null){
                   callBack.onTaskVideoClicked(activitiesItem);
               }
           }
       });
       holder.link_quiz.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(callBack != null){
                     callBack.onTaskQuizClicked(activitiesItem);
               }
           }
       });
    }

    @Override
    public int getItemCount() {
        return activitiesItems.size();
    }

    public void setCallBack(PlayVideoCallBack callBack) {
        this.callBack = callBack;
    }
}
