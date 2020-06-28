package com.sfac.AGlobalVoiceForAutism;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CommunityActivity extends AppCompatActivity {
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
                Intent wpp = new Intent(context, WhatsappListActivity.class);
                startActivity(wpp);
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
        Intent intOrg = new Intent(Intent.ACTION_VIEW);
        intOrg.setData(Uri.parse("https://www.aglobalvoiceforautism.org"));
        if(intOrg.resolveActivity(getPackageManager())!=null){
            startActivity(intOrg);
        }
    }
}
