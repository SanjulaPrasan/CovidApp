package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ui1.R;

import java.util.Timer;
import java.util.TimerTask;

public class Privacy extends AppCompatActivity {
    private Button btnPrivacy;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        btnPrivacy = (Button) findViewById(R.id.btnNext);
        btnPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStart();
            }
        });

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Privacy.this,Home.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }

    public void openStart(){
        Intent intent = new Intent(this, Bluetooth.class);
        startActivity(intent);
    }
}