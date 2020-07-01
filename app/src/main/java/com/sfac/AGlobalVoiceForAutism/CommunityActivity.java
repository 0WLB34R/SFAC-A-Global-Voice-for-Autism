package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.sfac.AGlobalVoiceForAutism.activities.CommunityLoginActivity;

public class CommunityActivity extends AppCompatActivity {
    private static final String LOG = CommunityActivity.class.getName();
    private Context context;
    private ImageButton imgBtnWhatsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        context = this;
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#8BC34A"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.com_section);

        imgBtnWhatsapp = findViewById(R.id.waButton);


        imgBtnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wppG = new Intent(context, WhatsappListActivity.class);
                startActivity(wppG);
            }
        });

    }

    public void toFacebook(View view){
        Intent intFace = new Intent(Intent.ACTION_VIEW);
        intFace.setData(Uri.parse("https://www.facebook.com/aglobalvoiceforautism"));
        if(intFace.resolveActivity(getPackageManager())!=null){
            startActivity(intFace);
        }
    }

    public void toLocalorg(View view){
        Intent intOrg = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.aglobalvoiceforautism.org"));
        startActivity(intOrg);
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

    public void enableFilters(View view){
        Intent intent = new Intent(this, CommunityLoginActivity.class);
        intent.putExtra("filter_on",1);
        startActivity(intent);
    }
}
