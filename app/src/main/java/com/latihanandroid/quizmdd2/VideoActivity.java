package com.latihanandroid.quizmdd2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private static final  int RECORVERY_DIALOG_REQUEST=1;
    private YouTubePlayerView youTubePlayerView;
    private Button btnKembali;
    private int pilihan=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video);
        pilihan=getIntent().getIntExtra("Pilihan",0);
        youTubePlayerView= (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(Config.DEVELOPER_KEY,this);
        btnKembali=(Button) findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b){
            String VideoKey="";
            switch (pilihan){
                case 0: VideoKey=Config.YOUTUBE_VIDEO_KEY_1;
                break;
                case 1:VideoKey=Config.YOUTUBE_VIDEO_KEY_2;
                break;

                case 2:VideoKey=Config.YOUTUBE_VIDEO_KEY_3;
                    break;
            }
            youTubePlayer.loadVideo(VideoKey);
            youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,RECORVERY_DIALOG_REQUEST).show();
        }
        else {
            String errorMessage= String.format("Error "+ youTubeInitializationResult.toString());
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==RECORVERY_DIALOG_REQUEST){
            getYoutubePlayerProvider().initialize(Config.DEVELOPER_KEY,this);
        }
    }

    private YouTubePlayer.Provider getYoutubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
}
