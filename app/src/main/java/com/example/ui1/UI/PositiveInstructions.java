package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ui1.R;

import java.util.Timer;
import java.util.TimerTask;

public class PositiveInstructions extends AppCompatActivity {

    Timer timer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positive_instructions);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(PositiveInstructions.this,Home.class);
                startActivity(intent);
                finish();
            }
        },5000);





    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}