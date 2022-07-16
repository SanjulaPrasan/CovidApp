package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.ui1.Bluetooth.BluetoothActivity;
import com.example.ui1.R;

public class Home extends AppCompatActivity {
    private TextView status;
    VideoView videoView;

    private Button btnStats;
    private  Button btnSelfAss;
    private Button btnProf;
    public static String health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        status = findViewById(R.id.tvStatusValue);

        SharedPreferences sharedPreferences = getSharedPreferences(SelfAssessment.SHARED_PREFS, MODE_PRIVATE);
        health = sharedPreferences.getString(SelfAssessment.TEXT, "");

        status.setText("" + health);

        this.videoView = findViewById(R.id.vvBlueScan);
        this.videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.blue_scan2));
        MediaController videoControl = new MediaController(this);
        videoControl.setAnchorView(this.videoView);
        //this.videoView.setMediaController(videoControl);
        this.videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBTScan();
            }
        });

        btnStats = (Button) findViewById(R.id.btnStats);
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStats();
            }
        });
        btnSelfAss = (Button) findViewById(R.id.btnSelfAss);
        btnSelfAss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelfAss();
            }
        });
        btnProf = (Button) findViewById(R.id.btnProf);
        btnProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProf();
            }
        });
    }

    public void openStats(){
        Intent intent = new Intent(this, Stats.class);
        startActivity(intent);
    }
    public void openSelfAss(){
        Intent intent = new Intent(this, SelfAssessmentHome.class);
        startActivity(intent);
    }
    public void openProf(){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
    public void openBTScan(){
        Intent intent = new Intent(this, BluetoothActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPostResume() {
        videoView.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart() {
        videoView.start();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        videoView.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        videoView.stopPlayback();
        super.onDestroy();
    }
}