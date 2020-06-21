package com.sfac.AGlobalVoiceForAutism;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.google.gson.Gson;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;
import com.sfac.AGlobalVoiceForAutism.repository.VideoRepository;
import com.sfac.AGlobalVoiceForAutism.utils.Constants;

import java.security.Principal;

public class PopUpVideoActivity extends AppCompatActivity {
    private static final String LOG = PopUpVideoActivity.class.getSimpleName();


    private RelativeLayout popupRelativeLayout;
    private EditText idEditText;
    private EditText nameEditText;

    private Button findVideoButton;

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
        addEvents();
    }

    private void addEvents(){
        findVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 validateVideo();
            }
        });
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

        TextView idTextView = new TextView(context);
        idTextView.setText(getString(R.string.register_id));
        VideoFormLinearLayout.addView(idTextView);
        idEditText = new EditText(context);
        VideoFormLinearLayout.addView(idEditText);

        TextView nameTextView = new TextView(context);
        nameTextView.setText(getString(R.string.register_name));
        VideoFormLinearLayout.addView(nameTextView);
        nameEditText = new EditText(context);
        VideoFormLinearLayout.addView(nameEditText);

        findVideoButton = new Button(context);
        findVideoButton.setBackgroundResource(R.color.backgroundColor3);
        findVideoButton.setTextColor(getResources().getColor(android.R.color.white));
        findVideoButton.setText(getString(R.string.find_video));

        LinearLayout.LayoutParams loginLp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        loginLp.setMargins(0, 50, 0, 0);
        findVideoButton.setLayoutParams(loginLp);
        VideoFormLinearLayout.addView(findVideoButton);

        PrincipalRelativeLayout.addView(VideoFormLinearLayout);
        return PrincipalRelativeLayout;
    }
    private void validateVideo(){
        String nameVideo = nameEditText.getText().toString().trim();
        String idVideo = idEditText.getText().toString().trim();
        if(idVideo.isEmpty() || nameVideo.isEmpty()){
            Toast.makeText(context, getString(R.string.empty_fields),Toast.LENGTH_SHORT).show();
            return;
        }
        ActivitiesItem extraVideo = VideoRepository.getInstance().reproduceVideo(idVideo,nameVideo);
        if(extraVideo == null){
            Toast.makeText(context,getString(R.string.not_valid_video),Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intentVideo = new Intent(context, VideoActivity.class);
        String videoString = new Gson().toJson(extraVideo);
        intentVideo.putExtra(Constants.INTENT_KEY_ACTIVITY,videoString);
        startActivity(intentVideo);
    }
}
