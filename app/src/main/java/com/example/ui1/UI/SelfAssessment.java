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
                if(switchFever.isChecked()){
                    i++;
                    Log.d("", "1 fever printed");
                }else{
                    i--;
                    Log.d("", "0 fever printed");
                }
            }
        });
        switchCough = findViewById(R.id.switchBtnCough);
        switchCough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCough.isChecked()){
                    i++;
                    Log.d("", "1 cough printed");
                }else{
                    i--;
                    Log.d("", "0 cough printed");
                }
            }
        });
        switchFatigue = findViewById(R.id.switchBtnFatigue);
        switchFatigue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchFatigue.isChecked()){
                    i++;
                    Log.d("", "1 fatigue printed");
                }else{
                    i--;
                    Log.d("", "0 fatigue printed");
                }
            }
        });
        switchBreathing = findViewById(R.id.switchBtnBreathing);
        switchBreathing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchBreathing.isChecked()){
                    i++;
                    Log.d("", "1 bbb printed");
                }else{
                    i--;
                    Log.d("", "0 bbb printed");
                }
            }
        });
        switchCovid = findViewById(R.id.switchBtnCovid);
        switchCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCovid.isChecked()){
                    i++;
                    Log.d("", "1 covid printed");
                }else{
                    i--;
                    Log.d("", "0 covid printed");
                }
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
    }

    public void openHome(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}