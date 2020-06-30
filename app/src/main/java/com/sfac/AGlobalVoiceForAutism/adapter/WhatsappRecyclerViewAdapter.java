package com.sfac.AGlobalVoiceForAutism.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfac.AGlobalVoiceForAutism.R;
import com.sfac.AGlobalVoiceForAutism.callBack.PlayVideoCallBack;

import com.sfac.AGlobalVoiceForAutism.callBack.WhatsappCallBack;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;
import com.sfac.AGlobalVoiceForAutism.model.Whatsapp;

import java.util.List;

public class WhatsappRecyclerViewAdapter extends RecyclerView.Adapter<WhatsappViewHolder>  {
    private List<Whatsapp> WhatsappGroup;
    private LayoutInflater inflater;
    private WhatsappCallBack callBack;

    public WhatsappRecyclerViewAdapter(Context context , List<Whatsapp> whatsapp) {
       this.WhatsappGroup = whatsapp;
        this.inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WhatsappViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = this.inflater.inflate(R.layout.activity_whatsapplist_activities,null);
        return new WhatsappViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WhatsappViewHolder holder, int position) {
        final Whatsapp Whatsapp = this.WhatsappGroup.get(position);
        holder.title.setText(Whatsapp.getTitle());
        holder.description.setText(Whatsapp.getDescription());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callBack != null){
                    callBack.onGroupClicked(Whatsapp);                }
            }
        });
        holder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callBack != null){
                    callBack.onGroupClicked(Whatsapp);                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return WhatsappGroup.size();
    }
    public void setCallBack(WhatsappCallBack callBack) {
        this.callBack = callBack;
    }
}

