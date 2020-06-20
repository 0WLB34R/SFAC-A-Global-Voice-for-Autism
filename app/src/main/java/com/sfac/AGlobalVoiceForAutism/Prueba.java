package com.sfac.AGlobalVoiceForAutism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;
import com.sfac.AGlobalVoiceForAutism.utils.Constants;

public class Prueba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
        receiveValues();
    }
    private void receiveValues() {
        Intent intent = getIntent();
        if (intent.hasExtra(Constants.INTENT_KEY_ACTIVITY)) {
            String userObj = intent.getStringExtra(Constants.INTENT_KEY_ACTIVITY);
            ActivitiesItem aI = new Gson().fromJson(userObj, ActivitiesItem.class);
            Toast.makeText(Prueba.this,
                    "Bienvenid@: "+ aI.getId() + aI.getExtention()+aI.getName() ,
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
//
