package dev.andeng.noteapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity class for displaying a splash screen with a video.
 * The video is played automatically and then transitions to the main activity.
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        VideoView videoView = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash);

        videoView.setVideoURI(videoUri);
        videoView.setOnCompletionListener(mp -> {
            // After the video finishes, transition to the main activity
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        videoView.start();
    }
}
