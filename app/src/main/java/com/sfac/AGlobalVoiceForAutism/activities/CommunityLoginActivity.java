package com.sfac.AGlobalVoiceForAutism.activities;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.sfac.AGlobalVoiceForAutism.CommunityActivity;
import com.sfac.AGlobalVoiceForAutism.R;
import com.sfac.AGlobalVoiceForAutism.sql.DataBaseHelper;

public class CommunityLoginActivity  extends AppCompatActivity implements onClickListener{
    private static final String LOG = CommunityLoginActivity.class.getName();
    private EditText username, password;
    private Button signinlog;
    DataBaseHelper DataBase;
    private SharedPreferences userpreferences;
    private SharedPreferences.Editor editor;

    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";

    private static final String SHARED_PREF = "sharedPrefs";
    private static final String S1 = "s1";
    private Switch s1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        int filterOn = bundle.getInt("filter_on");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logincommunity);
        s1 = (Switch) findViewById(R.id.disablefilter);
        if(filterOn == 1){
            SharedPreferences sp = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(S1, false);
            editor.apply();
        }
        s1.setChecked(loadData());
        if(loadData()){
            Intent intent = new Intent(getApplicationContext(), CommunityActivity.class);
            startActivity(intent);
        }
        username = (EditText) findViewById((R.id.usernamelog));
        password = (EditText) findViewById((R.id.passwordlog));
        signinlog = (Button) findViewById((R.id.signinlog));

        userpreferences = getSharedPreferences("loginprefs", MODE_PRIVATE);
        editor = userpreferences.edit();

        DataBase = new DataBaseHelper(this);


        signinlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(" ")) {
                    Toast.makeText(CommunityLoginActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();

                } else {
                    Boolean checkuserpass = DataBase.checkusernamepassword(user, pass);
                    if (checkuserpass) {
                        saveData();
                        Toast.makeText(CommunityLoginActivity.this, "Sign In successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), CommunityActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(CommunityLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void goToRegister(View view){
        Intent intent = new Intent(getApplicationContext(), CommunityMainActivity.class);
        startActivity(intent);
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

    public void saveData(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(S1, s1.isChecked());
        editor.apply();
    }

    public boolean loadData(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        return sp.getBoolean(S1,false);
    }

}