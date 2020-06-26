package com.sfac.AGlobalVoiceForAutism;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CommunityActivity extends AppCompatActivity {
    private ImageButton imgBtnFacebook;
    private ImageButton imgBtnWhatsapp;
    private ImageButton imgbtnLocalOrg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#8BC34A"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.com_section);

        imgBtnFacebook = findViewById(R.id.fbButton);
        imgBtnWhatsapp = findViewById(R.id.waButton);
        imgbtnLocalOrg = findViewById(R.id.loButton);
    }

    public void toFacebook(View view){
        Intent intFace = new Intent(Intent.ACTION_VIEW);
        intFace.setData(Uri.parse("https://www.facebook.com/aglobalvoiceforautism"));
        if(intFace.resolveActivity(getPackageManager())!=null){
            startActivity(intFace);
        }
    }

    public void toWhatsapp(View view){
        Intent intFace = new Intent(Intent.ACTION_VIEW);
        intFace.setData(Uri.parse("https://chat.whatsapp.com/F0I6pS6vKcB8RzGfdEMm7y"));
        if(intFace.resolveActivity(getPackageManager())!=null){
            startActivity(intFace);
        }
    }
    //public void toLocalorg(View view){
    //    Intent intFace = new Intent(Intent.ACTION_VIEW);
    //    intFace.setData(Uri.parse("https://www.facebook.com/aglobalvoiceforautism"));
    //    if(intFace.resolveActivity(getPackageManager())!=null){
    //        startActivity(intFace);
    //    }
    //}
}
