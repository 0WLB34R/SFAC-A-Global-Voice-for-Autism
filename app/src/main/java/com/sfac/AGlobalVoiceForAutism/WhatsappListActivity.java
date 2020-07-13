package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sfac.AGlobalVoiceForAutism.adapter.WhatsappRecyclerViewAdapter;
import com.sfac.AGlobalVoiceForAutism.callBack.WhatsappCallBack;
import com.sfac.AGlobalVoiceForAutism.model.Whatsapp;

import java.util.ArrayList;
import java.util.List;

public class WhatsappListActivity extends AppCompatActivity {
    private static final String LOG = WhatsappListActivity.class.getName();
    private Context context;
    private RecyclerView recyclerview;
    private WhatsappRecyclerViewAdapter wadapter;
    private List<Whatsapp> group = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapplist);
        context=this;

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#8BC34A"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Group List");
        initViews();
        addEvents();
        fillWhatsappVideoGroups();

    }
    private void initViews(){
        recyclerview=findViewById(R.id.GroupList);
        wadapter=new WhatsappRecyclerViewAdapter(context, group);
        recyclerview.setAdapter(wadapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(context));
    }

    private void addEvents(){
        wadapter.setCallBack(new WhatsappCallBack() {
            @Override
            public void onGroupClicked(Whatsapp task) {
                Intent wpp = new Intent(Intent.ACTION_VIEW);
                wpp.setData(Uri.parse(task.getUrl()));
                if(wpp.resolveActivity(getPackageManager())!=null){
                    startActivity(wpp);
                }
            }
        });
    }

    private void fillWhatsappVideoGroups(){
        group.add(new Whatsapp("TT_AGVFA تدريب التواليت","Toilet Training Support","https://chat.whatsapp.com/EnRYt0l04UB5dVryZajaLy"));
        group.add(new Whatsapp("AT-AGVFA تدريب الأنشطة","Activities Support","https://chat.whatsapp.com/GqTxicgLre5F6tmKGWwrZW"));
        group.add(new Whatsapp("CT-AGVFA تدريب التواصل","Communcation Training Support","https://chat.whatsapp.com/HbIDqS7hPap8lxDmDRYRVW"));
        group.add(new Whatsapp("SIB-AGVFA سلوك إيذاء نفس","Self-Injurious Behaviors Support","https://chat.whatsapp.com/E2AClRUNY9g0JFrRDUCkDI"));
        group.add(new Whatsapp("مجتمع الصوت العالمي للتوح","A Global Voice for Autism Global Arabic Community Group","https://chat.whatsapp.com/IN05nmWmEYXCAdCVdAHMJD"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LOG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LOG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LOG, "onDestroy");
    }

}
