package com.sfac.AGlobalVoiceForAutism;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.security.Principal;

public class PopUpVideoActivity extends AppCompatActivity {
    private static final String LOG = PopUpVideoActivity.class.getSimpleName();


    private RelativeLayout popupRelativeLayout;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText extensionEditText;

    private Button loginActionButton;

    private static final int FOOTER_ID = 100;

    private Context context;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#466060"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        setContentView(render());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private View render(){
        RelativeLayout PrincipalRelativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams transparentLp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        PrincipalRelativeLayout.setLayoutParams(transparentLp);
        PrincipalRelativeLayout.setBackgroundColor(getResources().getColor(R.color.backgroundColor2));
        PrincipalRelativeLayout.setPadding(100, 0, 100, 0);
        LinearLayout VideoFormLinearLayout = new LinearLayout(context);
        VideoFormLinearLayout.setOrientation(LinearLayout.VERTICAL);
        VideoFormLinearLayout.setBackground(getDrawable(R.drawable.style_form));

        RelativeLayout.LayoutParams formLp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        formLp.addRule(RelativeLayout.CENTER_VERTICAL);
        VideoFormLinearLayout.setLayoutParams(formLp);

        TextView emailTextView = new TextView(context);
        emailTextView.setText(getString(R.string.register_id));
        VideoFormLinearLayout.addView(emailTextView);
        emailEditText = new EditText(context);
        VideoFormLinearLayout.addView(emailEditText);

        //Label
        TextView passwordTextView = new TextView(context);
        passwordTextView.setText(getString(R.string.register_name));
        VideoFormLinearLayout.addView(passwordTextView);
        passwordEditText = new EditText(context);
        VideoFormLinearLayout.addView(passwordEditText);
        //Label
        TextView extensionTextView = new TextView(context);
        extensionTextView.setText(getString(R.string.register_extension));
        VideoFormLinearLayout.addView(extensionTextView);
        extensionEditText = new EditText(context);
        VideoFormLinearLayout.addView(extensionEditText);

        loginActionButton = new Button(context);
        loginActionButton.setBackgroundResource(R.color.backgroundColor3);
        loginActionButton.setTextColor(getResources().getColor(android.R.color.white));
        loginActionButton.setText(getString(R.string.find_video));

        LinearLayout.LayoutParams loginLp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        loginLp.setMargins(0, 50, 0, 0);
        loginActionButton.setLayoutParams(loginLp);
        VideoFormLinearLayout.addView(loginActionButton);

        PrincipalRelativeLayout.addView(VideoFormLinearLayout);
        return PrincipalRelativeLayout;
    }
}
