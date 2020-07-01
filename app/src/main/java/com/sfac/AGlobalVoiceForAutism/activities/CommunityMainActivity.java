package com.sfac.AGlobalVoiceForAutism.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sfac.AGlobalVoiceForAutism.CommunityActivity;
import com.sfac.AGlobalVoiceForAutism.R;
import com.sfac.AGlobalVoiceForAutism.sql.DataBaseHelper;

public class CommunityMainActivity extends AppCompatActivity {
    private static final String LOG = CommunityMainActivity.class.getName();;
    private Context context;
    EditText username, password, repassword, name, age, country, email;
    Button singup, signin;
    DataBaseHelper DataBase;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communitymain);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        country = (EditText) findViewById(R.id.country);
        email = (EditText) findViewById(R.id.email);
        singup = (Button) findViewById(R.id.SignUp);
        signin = (Button) findViewById(R.id.SignIn);
        DataBase = new DataBaseHelper(this);
        context = this;

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String namefull = name.getText().toString();
                String agetotal = age.getText().toString();
                String countryfrom = country.getText().toString();
                String emailin = email.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals("")||namefull.equals("")||agetotal.equals("")||countryfrom.equals("")||emailin.equals(""))
                    Toast.makeText(CommunityMainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DataBase.checkusername(user);
                        if(checkuser == false){
                            Boolean insert = DataBase.insertData(user, pass, namefull, agetotal,countryfrom, emailin);
                            if(insert == true){
                                Toast.makeText(CommunityMainActivity.this, "Registered succesfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), CommunityActivity.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(CommunityMainActivity.this, "Registration failed :(", Toast.LENGTH_SHORT).show();

                            }

                        }
                        else{
                            Toast.makeText(CommunityMainActivity.this, "User already exits, please Sign In",Toast.LENGTH_SHORT).show();

                        }
                    }
                    else{
                        Toast.makeText(CommunityMainActivity.this, "Passwords are not matching",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommunityLoginActivity.class);
                intent.putExtra("filter_on",0);
                startActivity(intent);
            }
        });

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
