package com.sfac.AGlobalVoiceForAutism;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WhatsappListActivity extends AppCompatActivity {
    private static final String LOG = WhatsappListActivity.class.getName();
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
        wpp.setData(Uri.parse("https://chat.whatsapp.com/GKh3AvtygncALOhJdDW8tu"));
            startActivity(wpp);
    }
    public void toWhatsapp2(View view){
        Intent wpp = new Intent(Intent.ACTION_VIEW);
        wpp.setData(Uri.parse("https://chat.whatsapp.com/F0I6pS6vKcB8RzGfdEMm7y"));
        startActivity(wpp);
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
