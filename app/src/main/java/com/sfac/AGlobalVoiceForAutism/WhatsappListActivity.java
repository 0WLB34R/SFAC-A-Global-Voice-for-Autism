package com.sfac.AGlobalVoiceForAutism;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WhatsappListActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapplist);

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#8BC34A"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Group List");
    }



    public void toWhatsapp(View view){
        Intent wpp = new Intent(Intent.ACTION_VIEW);
        wpp.setData(Uri.parse("https://chat.whatsapp.com/F0I6pS6vKcB8RzGfdEMm7y"));
            startActivity(wpp);
    }
    public void toWhatsapp2(View view){
        Intent wpp = new Intent(Intent.ACTION_VIEW);
        wpp.setData(Uri.parse("https://chat.whatsapp.com/F0I6pS6vKcB8RzGfdEMm7y"));
        startActivity(wpp);
    }
    public void toWhatsapp3(View view){
        Intent wpp = new Intent(Intent.ACTION_VIEW);
        wpp.setData(Uri.parse("https://chat.whatsapp.com/F0I6pS6vKcB8RzGfdEMm7y"));
        startActivity(wpp);
    }

}
