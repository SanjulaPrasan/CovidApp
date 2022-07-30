package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.ui1.R;

import java.util.Timer;
import java.util.TimerTask;

public class ModerateRiskInstructions extends AppCompatActivity {
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderate_risk_instructions);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ModerateRiskInstructions.this,Home.class);
                startActivity(intent);
                finish();
            }
        },60000*3);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(ModerateRiskInstructions.this,Home.class);
        startActivity(intent);
        finish();
    }
}