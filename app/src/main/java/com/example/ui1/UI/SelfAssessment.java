package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ui1.R;

public class SelfAssessment extends AppCompatActivity {

    private Button  btnSubmit;
    private SwitchCompat switchFever, switchCough, switchFatigue, switchBreathing, switchCovid;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        switchFever = findViewById(R.id.switchBtnFever);
        switchFever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCovid.isChecked()){
                    switchFever.setChecked(true);
                    Log.d("", "COVID POSITIVE");
                }else{
                    if(switchFever.isChecked()){
                        i++;
                        Log.d("", "1 fever printed");
                    }else {
                        i--;
                        Log.d("", "0 fever printed");
                    }
                }
            }
        });
        switchCough = findViewById(R.id.switchBtnCough);
        switchCough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCovid.isChecked()){
                    switchCough.setChecked(true);
                    Log.d("", "COVID POSITIVE");
                }else{
                    if(switchCough.isChecked()){
                        i++;
                        Log.d("", "1 cough printed");
                    }else {
                        i--;
                        Log.d("", "0 cough printed");
                    }
                }
            }
        });
        switchFatigue = findViewById(R.id.switchBtnFatigue);
        switchFatigue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCovid.isChecked()){
                    switchFatigue.setChecked(true);
                    Log.d("", "COVID POSITIVE");
                }else{
                    if(switchFatigue.isChecked()){
                        i++;
                        Log.d("", "1 fatigue printed");
                    }else {
                        i--;
                        Log.d("", "0 fatigue printed");
                    }
                }
            }
        });
        switchBreathing = findViewById(R.id.switchBtnBreathing);
        switchBreathing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCovid.isChecked()){
                    switchBreathing.setChecked(true);
                    Log.d("", "COVID POSITIVE");
                }else{
                    if(switchBreathing.isChecked()){
                        i++;
                        Log.d("", "1 breathing difficulty printed");
                    }else {
                        i--;
                        Log.d("", "0 breathing difficulty printed");
                    }
                }
            }
        });
        switchCovid = findViewById(R.id.switchBtnCovid);
        switchCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCovid.isChecked()){
                    switchFever.setChecked(true);
                    switchCough.setChecked(true);
                    switchFatigue.setChecked(true);
                    switchBreathing.setChecked(true);
                    i=5;
                    Log.d("", "1 covid printed");
                }else{
                    switchFever.setChecked(false);
                    switchCough.setChecked(false);
                    switchFatigue.setChecked(false);
                    switchBreathing.setChecked(false);
                    i=0;
                    Log.d("", "0 covid printed");
                }
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
                Log.d("", "value: " + Integer.toString(i));
            }
        });
    }

    public void openHome(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}