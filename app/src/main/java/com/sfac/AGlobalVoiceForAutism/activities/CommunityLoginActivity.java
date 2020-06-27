package com.sfac.AGlobalVoiceForAutism.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sfac.AGlobalVoiceForAutism.CommunityActivity;
import com.sfac.AGlobalVoiceForAutism.R;
import com.sfac.AGlobalVoiceForAutism.sql.DataBaseHelper;

public class CommunityLoginActivity  extends AppCompatActivity {
    EditText username, password;
    Button signinlog;
    DataBaseHelper DataBase;
    private Context context;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logincommunity);
        username = (EditText) findViewById((R.id.usernamelog));
        password = (EditText) findViewById((R.id.passwordlog));
        signinlog = (Button) findViewById((R.id.signinlog));
        DataBase = new DataBaseHelper(this);

        signinlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(" "))
                    Toast.makeText(CommunityLoginActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DataBase.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(CommunityLoginActivity.this,"Sign In successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), CommunityActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(CommunityLoginActivity.this, "Invalid Credintials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
