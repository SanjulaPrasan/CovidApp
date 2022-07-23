package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.ui1.R;

public class SelfAssessment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "SelfAssessment";

    private Button btnSubmit;
    Spinner spinnerFever, spinnerCough, spinnerDiarrhea, spinnerBodyPain, spinnerHeadache, spinnerLossOfSmell, spinnerRA, spinnerPCR;
    ArrayAdapter<CharSequence> feverAdapter, coughAdapter, diarrheaAdapter, bodyPainAdapter, headacheAdapter, lossOfSmellAdapter, raAdapter, pcrAdapter;
//    public static String fever, cough, diarrhea, bodyPain, headache, lossOfSmell;
//    private int i = 0;

    public static String healthStatus;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment);


        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        spinnerFever = (Spinner) findViewById(R.id.spinFever);
        feverAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        feverAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFever.setAdapter(feverAdapter);
        spinnerFever.setOnItemSelectedListener(this);

        spinnerCough = (Spinner) findViewById(R.id.spinCough);
        coughAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        coughAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCough.setAdapter(coughAdapter);
        spinnerCough.setOnItemSelectedListener(this);

        spinnerDiarrhea = (Spinner) findViewById(R.id.spinDiarrhea);
        diarrheaAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        diarrheaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDiarrhea.setAdapter(diarrheaAdapter);
        spinnerDiarrhea.setOnItemSelectedListener(this);

        spinnerBodyPain = (Spinner) findViewById(R.id.spinBodyPain);
        bodyPainAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        bodyPainAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBodyPain.setAdapter(bodyPainAdapter);
        spinnerBodyPain.setOnItemSelectedListener(this);

        spinnerHeadache = (Spinner) findViewById(R.id.spinHeadache);
        headacheAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        headacheAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHeadache.setAdapter(headacheAdapter);
        spinnerHeadache.setOnItemSelectedListener(this);

        spinnerLossOfSmell = (Spinner) findViewById(R.id.spinLossSmell);
        lossOfSmellAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        lossOfSmellAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLossOfSmell.setAdapter(lossOfSmellAdapter);
        spinnerLossOfSmell.setOnItemSelectedListener(this);

//        switchFever = findViewById(R.id.switchBtnFever);
//
//
//        switchFever.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (switchCovid.isChecked()) {
//                    switchFever.setChecked(true);
//                } else {
//                    if (switchFever.isChecked()) {
//                        i++;
//                    } else {
//                        i--;
//                    }
//                }
//            }
//        });
//        switchCough = findViewById(R.id.switchBtnCough);
//        switchCough.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (switchCovid.isChecked()) {
//                    switchCough.setChecked(true);
//                } else {
//                    if (switchCough.isChecked()) {
//                        i++;
//                    } else {
//                        i--;
//                    }
//                }
//            }
//        });
//        switchFatigue = findViewById(R.id.switchBtnFatigue);
//        switchFatigue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (switchCovid.isChecked()) {
//                    switchFatigue.setChecked(true);
//                } else {
//                    if (switchFatigue.isChecked()) {
//                        i++;
//                    } else {
//                        i--;
//                    }
//                }
//            }
//        });
//        switchBreathing = findViewById(R.id.switchBtnBreathing);
//        switchBreathing.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (switchCovid.isChecked()) {
//                    switchBreathing.setChecked(true);
//                } else {
//                    if (switchBreathing.isChecked()) {
//                        i++;
//                    } else {
//                        i--;
//                    }
//                }
//            }
//        });
//        switchCovid = findViewById(R.id.switchBtnCovid);
//        switchCovid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (switchCovid.isChecked()) {
//                    switchFever.setChecked(true);
//                    switchCough.setChecked(true);
//                    switchFatigue.setChecked(true);
//                    switchBreathing.setChecked(true);
//                    i = 5;
//                } else {
//                    switchFever.setChecked(false);
//                    switchCough.setChecked(false);
//                    switchFatigue.setChecked(false);
//                    switchBreathing.setChecked(false);
//                    i = 0;
//                }
//            }
//        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                generateHealthStatus();
                saveData();
                Log.d(TAG, "Health Status " + healthStatus);

//                openHome();
            }
        });
    }


//    public static void generateHealthStatus(){
//        fever = spinnerFever.getSelectedItem().toString();
//        cough = spinnerCough.getSelectedItem().toString();
//        diarrhea = spinnerDiarrhea.getSelectedItem().toString();
//        bodyPain = spinnerBodyPain.getSelectedItem().toString();
//        headache = spinnerHeadache.getSelectedItem().toString();
//        lossOfSmell = spinnerLossOfSmell.getSelectedItem().toString();
//
//        if(fever.equals("No") && cough.equals("No") && diarrhea.equals("No") && bodyPain.equals("No") && headache.equals("No") && lossOfSmell.equals("No")){
//            healthStatus = "NEGATIVE";
//        } else if(fever.equals("1-5 Days") || cough.equals("1-5 Days") || diarrhea.equals("1-5 Days") || bodyPain.equals("1-5 Days") || headache.equals("1-5 Days") || lossOfSmell.equals("1-5 Days")){
//            healthStatus = "LOW RISK";
//        }
//    }


    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, healthStatus);

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }


    public void openHome(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onBackPressed() {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String fever = parent.getItemAtPosition(position).toString();
        String cough = parent.getItemAtPosition(position).toString();
        String diarrhea = parent.getItemAtPosition(position).toString();
        String bodyPain = parent.getItemAtPosition(position).toString();
        String headache = parent.getItemAtPosition(position).toString();
        String lossOfSmell = parent.getItemAtPosition(position).toString();

        if(fever.equals("No") && cough.equals("No") && diarrhea.equals("No") && bodyPain.equals("No") && headache.equals("No") && lossOfSmell.equals("No")){
            healthStatus = "NEGATIVE";
        } else if(fever.equals("1-5 Days") || cough.equals("1-5 Days") || diarrhea.equals("1-5 Days") || bodyPain.equals("1-5 Days") || headache.equals("1-5 Days") || lossOfSmell.equals("1-5 Days")){
            healthStatus = "LOW RISK";
        } else if(fever.equals("5-10 Days") || cough.equals("5-10 Days") || diarrhea.equals("5-10 Days") || bodyPain.equals("5-10 Days") || headache.equals("5-10 Days") || lossOfSmell.equals("5-10 Days")) {
            healthStatus = "HIGH RISK";
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}