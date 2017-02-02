package com.example.hedgehogus.videovideo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.videoView);


        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus(0);


        MediaPlayer.OnCompletionListener myVideoViewCompletionListener
                = new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer arg0) {
                Toast.makeText(getApplicationContext(),
                        "End of Video",
                        Toast.LENGTH_LONG).show();
            }
        };

        MediaPlayer.OnPreparedListener MyVideoViewPreparedListener
                = new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer arg0) {
                Toast.makeText(getApplicationContext(),
                        "Media file is loaded and ready to go",
                        Toast.LENGTH_LONG).show();

            }
        };

        MediaPlayer.OnErrorListener myVideoViewErrorListener
                = new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
                Toast.makeText(getApplicationContext(),
                        "Error!!!",
                        Toast.LENGTH_LONG).show();
                return true;
            }
        };

        videoView.setOnCompletionListener(myVideoViewCompletionListener);
        videoView.setOnPreparedListener(MyVideoViewPreparedListener);
        videoView.setOnErrorListener(myVideoViewErrorListener);

        String videoSource ="https://instagram.fhen1-1.fna.fbcdn.net/t50.2886-16/16442170_248865052221894_5831680433863000064_n.mp4";
        videoView.setVideoURI(Uri.parse(videoSource));
        videoView.start();
    }

}
