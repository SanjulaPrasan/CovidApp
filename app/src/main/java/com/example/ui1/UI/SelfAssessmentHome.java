package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ui1.R;

public class SelfAssessmentHome extends AppCompatActivity {

    private Button btnSubmit;
    private Button  btnHome;
    private SwitchCompat switchFever, switchCough, switchFatigue, switchBreathing, switchCovid;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment_home);
        btnHome = (Button) findViewById(R.id.btnHome);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        switchFever = findViewById(R.id.switchBtnFever);
        switchFever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCovid.isChecked()) {
                    switchFever.setChecked(true);
                } else {
                    if (switchFever.isChecked()) {
                        i++;
                    } else {
                        i--;
                    }
                }
            }
        });
        switchCough = findViewById(R.id.switchBtnCough);
        switchCough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCovid.isChecked()) {
                    switchCough.setChecked(true);
                } else {
                    if (switchCough.isChecked()) {
                        i++;
                    } else {
                        i--;
                    }
                }
            }
        });
        switchFatigue = findViewById(R.id.switchBtnFatigue);
        switchFatigue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCovid.isChecked()) {
                    switchFatigue.setChecked(true);
                } else {
                    if (switchFatigue.isChecked()) {
                        i++;
                    } else {
                        i--;
                    }
                }
            }
        });
        switchBreathing = findViewById(R.id.switchBtnBreathing);
        switchBreathing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCovid.isChecked()) {
                    switchBreathing.setChecked(true);
                } else {
                    if (switchBreathing.isChecked()) {
                        i++;
                    } else {
                        i--;
                    }
                }
            }
        });
        switchCovid = findViewById(R.id.switchBtnCovid);
        switchCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCovid.isChecked()) {
                    switchFever.setChecked(true);
                    switchCough.setChecked(true);
                    switchFatigue.setChecked(true);
                    switchBreathing.setChecked(true);
                    i = 5;
                } else {
                    switchFever.setChecked(false);
                    switchCough.setChecked(false);
                    switchFatigue.setChecked(false);
                    switchBreathing.setChecked(false);
                    i = 0;
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewHealthStatus(i);
                saveDataHome();
                openHome();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
    }

    public static void generateNewHealthStatus(int i){
        if(i == 5){
            SelfAssessment.healthStatus = "POSITIVE";
        }else if(i == 0){
            SelfAssessment.healthStatus = "NEGATIVE";
        }else if(i > 0 && i <3){
            SelfAssessment.healthStatus = "LOW RISK";
        }else{
            SelfAssessment.healthStatus = "HIGH RISK";
        }
    }


    public void saveDataHome(){
        SharedPreferences sharedPreferences = getSharedPreferences(SelfAssessment.SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(SelfAssessment.TEXT, SelfAssessment.healthStatus);

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void openHome(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}