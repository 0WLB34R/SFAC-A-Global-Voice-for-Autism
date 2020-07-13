package com.sfac.AGlobalVoiceForAutism;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;

public class AboutUsActivity extends AppCompatActivity {

    private static final String LOG =AboutUsActivity.class.getName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#A645B7"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About Us");
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
