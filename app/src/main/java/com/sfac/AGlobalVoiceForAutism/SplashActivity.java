package com.sfac.AGlobalVoiceForAutism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    private static final String LOG = SplashActivity.class.getSimpleName();
    private Context context;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_splash);
        initViews();

        simulateLoading();
    }

    private void initViews() {
        progressBar = findViewById(R.id.progressBar);
    }

    private void openNextScreen() {
       Intent MainIntent = new Intent(context, MainActivity.class);
        MainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(MainIntent);
    }

    private void simulateLoading() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                    updateProgress(20);

                    Thread.sleep(300);
                    updateProgress(40);

                    Thread.sleep(300);
                    updateProgress(60);

                    Thread.sleep(300);
                    updateProgress(70);

                    Thread.sleep(1100);
                    updateProgress(99);
                    openNextScreen();
                } catch (InterruptedException ex) {
                    Log.e(LOG, "InterruptedException." + ex.getMessage());
                }
            }
        }).start();
    }

    private void updateProgress(final int progress) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(progress);
            }
        });
    }
}

