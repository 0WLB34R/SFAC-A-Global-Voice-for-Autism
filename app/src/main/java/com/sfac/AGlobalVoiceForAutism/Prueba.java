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

        //2. Verificamos que el canal tenga el mensaje con la clave: "objUser"
        if (intent.hasExtra(Constants.INTENT_KEY_ACTIVITY)) {

            //3. Obtener el valor del mensaje con la clave: "objUser"
            String userObj = intent.getStringExtra(Constants.INTENT_KEY_ACTIVITY);

            //4. Convertir el String a un Objeto
            ActivitiesItem aI = new Gson().fromJson(userObj, ActivitiesItem.class);

            Toast.makeText(Prueba.this, //Origen
                    "Bienvenid@: "+ aI.getId() + aI.getExtention()+aI.getName() , //Mensaje
                    Toast.LENGTH_SHORT) //Duracion
                    .show();
        }
    }
}
//
