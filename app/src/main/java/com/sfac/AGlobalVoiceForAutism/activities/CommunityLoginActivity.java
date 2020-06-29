package com.sfac.AGlobalVoiceForAutism.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sfac.AGlobalVoiceForAutism.CommunityActivity;
import com.sfac.AGlobalVoiceForAutism.R;
import com.sfac.AGlobalVoiceForAutism.sql.DataBaseHelper;

public class CommunityLoginActivity  extends AppCompatActivity implements onClickListener{
    private static final String LOG = CommunityLoginActivity.class.getName();
    private EditText username, password;
    private Button signinlog;
    DataBaseHelper DataBase;
    private Context context;
    private CheckBox remembermecheckbox;
    private SharedPreferences userpreferences;
    private SharedPreferences.Editor editor;
    private Boolean saveLog;
    private static final String PREF_NAME = "prefs";
    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logincommunity);
        username = (EditText) findViewById((R.id.usernamelog));
        password = (EditText) findViewById((R.id.passwordlog));
        signinlog = (Button) findViewById((R.id.signinlog));
        remembermecheckbox = (CheckBox) findViewById(R.id.remembermecheckbox);

        userpreferences = getSharedPreferences("loginprefs", MODE_PRIVATE);
        editor = userpreferences.edit();

        DataBase = new DataBaseHelper(this);

        //saveLog = userpreferences.getBoolean("saveLog", false);
       /*/ if (saveLog == true) {
            username.setText(userpreferences.getString("user", ""));
            password.setText(userpreferences.getString("pass", ""));
            remembermecheckbox.setChecked(true);
        }/*/

        signinlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(" ")) {
                    Toast.makeText(CommunityLoginActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();

                } else {
                    Boolean checkuserpass = DataBase.checkusernamepassword(user, pass);
                    DataBaseHelper dataBaseHelper = new DataBaseHelper(CommunityLoginActivity.this);
                    if (remembermecheckbox.isChecked()) {
                        dataBaseHelper.checkusernamepassword(user,pass);
                        userpreferences = PreferenceManager.getDefaultSharedPreferences(CommunityLoginActivity.this);
                        editor = getSharedPreferences("loginprefs", MODE_PRIVATE).edit();
                        editor.putString("user", user.toString());
                        editor.putString("pass", pass.toString());
                        editor.commit();

                    } else {
                        //editor.clear();

                    }
                    if (checkuserpass == true) {
                        Toast.makeText(CommunityLoginActivity.this, "Sign In successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), CommunityActivity.class);
                        startActivity(intent);


                        //username.getText().clear();
                        //password.getText().clear();


                    } else {
                        Toast.makeText(CommunityLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

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