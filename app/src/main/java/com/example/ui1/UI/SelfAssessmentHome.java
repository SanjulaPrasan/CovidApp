package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ui1.R;

public class SelfAssessmentHome extends AppCompatActivity {

    private Button  btnHome;
    private SwitchCompat switchFever, switchCough, switchFatigue, switchBreathing, switchCovid;
    public static int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment_home);
        btnHome = (Button) findViewById(R.id.btnHome);

        switchFever = findViewById(R.id.switchBtnFever);
        switchFever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCovid.isChecked()) {
                    switchFever.setChecked(true);
                } else {
                    if (switchFever.isChecked()) {
                        j++;
                    } else {
                        j--;
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
                        j++;
                    } else {
                        j--;
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
                        j++;
                    } else {
                        j--;
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
                        j++;
                    } else {
                        j--;
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
                    j = 5;
                } else {
                    switchFever.setChecked(false);
                    switchCough.setChecked(false);
                    switchFatigue.setChecked(false);
                    switchBreathing.setChecked(false);
                    j = 0;
                }
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
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