package com.sfac.AGlobalVoiceForAutism;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.gson.Gson;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;
import com.sfac.AGlobalVoiceForAutism.utils.Constants;

import java.io.File;

import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static android.os.Environment.DIRECTORY_PICTURES;


public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener, YouTubePlayer.PlayerStateChangeListener {

    FirebaseStorage fireStorage;
    StorageReference sRef;
    StorageReference ref;
    YouTubePlayerView playerView;
    //String filename = "Elmo.jpg";
    //String videoId = "MeO8VIx-jXA";
    ActivitiesItem aI;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        playerView = (YouTubePlayerView) findViewById(R.id.ytplayerView);
        playerView.initialize(YouTubeConfig.getApiKey(), this);
        context = this;
        //check existence of video so the button can change value
        //change download to delete based on variable
        receiveValues();

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStateChangeListener(this);
        youTubePlayer.setPlaybackEventListener(this);

        if (!b) {
            youTubePlayer.cueVideo(aI.getId());
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoaded(String s) {

    }

    @Override
    public void onAdStarted() {

    }

    @Override
    public void onVideoStarted() {

    }

    @Override
    public void onVideoEnded() {

    }

    @Override
    public void onError(YouTubePlayer.ErrorReason errorReason) {

    }

    public void gotoQuiz(View view){
        Intent intent;
        if(aI.getId().equals("Hardcoded")){
            intent = new Intent(context, QuizActivity2.class);
        }else{
            intent = new Intent(context,QuizActivity.class);
        }
        startActivity(intent);

    }

    public void downloadVideo(View view) {
            sRef = fireStorage.getInstance().getReference();
            ref = sRef.child(aI.getName() + aI.getExtension());

            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String url = uri.toString();
                    //String name = filename.substring(0,filename.length()-4);
                    downloadFile(VideoActivity.this, aI.getName(), aI.getExtension(), DIRECTORY_DOWNLOADS, url);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
    }

    public void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        Toast.makeText(this, "Video downloaded to My Files",
                Toast.LENGTH_LONG).show();
        //here change ann SQL variable to show availability of video offline
        downloadManager.enqueue(request);
    }

    public void gotoVideoList(View view) {
        Intent intent = new Intent(this, VideoListActivity.class);
        startActivity(intent);

    }


    private void receiveValues() {
        Intent intent = getIntent();
        if (intent.hasExtra(Constants.INTENT_KEY_ACTIVITY)) {
            String userObj = intent.getStringExtra(Constants.INTENT_KEY_ACTIVITY);
            aI = new Gson().fromJson(userObj, ActivitiesItem.class);
        }
    }

}