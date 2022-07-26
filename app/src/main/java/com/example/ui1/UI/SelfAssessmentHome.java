package com.example.ui1.UI;

import static com.example.ui1.UI.Home.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ui1.R;

public class SelfAssessmentHome extends AppCompatActivity {

    private Button btnSubmit;
//    private Button  btnHome;
    private Spinner spinnerFever, spinnerCough, spinnerDiarrhea, spinnerBodyPain, spinnerHeadache, spinnerLossOfSmell, spinnerRA, spinnerPCR;
    private ArrayAdapter<CharSequence> feverAdapter, coughAdapter, diarrheaAdapter, bodyPainAdapter, headacheAdapter, lossOfSmellAdapter, raAdapter, pcrAdapter;
    private SwitchCompat switchBreathing, switchConscious;
    private String fever, cough, diarrhea, bodyPain, headache, lossOfSmell, rat, pcr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment_home);




//        btnHome = (Button) findViewById(R.id.btnHome);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        spinnerFever = (Spinner) findViewById(R.id.spinFever);
        feverAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        feverAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFever.setAdapter(feverAdapter);
        spinnerFever.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fever = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerCough = (Spinner) findViewById(R.id.spinCough);
        coughAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        coughAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCough.setAdapter(coughAdapter);
        spinnerCough.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cough = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerDiarrhea = (Spinner) findViewById(R.id.spinDiarrhea);
        diarrheaAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        diarrheaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDiarrhea.setAdapter(diarrheaAdapter);
        spinnerDiarrhea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                diarrhea = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerBodyPain = (Spinner) findViewById(R.id.spinBodyPain);
        bodyPainAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        bodyPainAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBodyPain.setAdapter(bodyPainAdapter);
        spinnerBodyPain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bodyPain = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerHeadache = (Spinner) findViewById(R.id.spinHeadache);
        headacheAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        headacheAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHeadache.setAdapter(headacheAdapter);
        spinnerHeadache.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                headache = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerLossOfSmell = (Spinner) findViewById(R.id.spinLossSmell);
        lossOfSmellAdapter = ArrayAdapter.createFromResource(this, R.array.fever, android.R.layout.simple_spinner_item);
        lossOfSmellAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLossOfSmell.setAdapter(lossOfSmellAdapter);
        spinnerLossOfSmell.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lossOfSmell = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerRA = (Spinner) findViewById(R.id.spinRAT);
        raAdapter = ArrayAdapter.createFromResource(this, R.array.test, android.R.layout.simple_spinner_item);
        raAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRA.setAdapter(raAdapter);
        spinnerRA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rat = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerPCR = (Spinner) findViewById(R.id.spinPCR);
        pcrAdapter = ArrayAdapter.createFromResource(this, R.array.test, android.R.layout.simple_spinner_item);
        pcrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPCR.setAdapter(pcrAdapter);
        spinnerPCR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pcr = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        switchBreathing = findViewById(R.id.switchBtnBreathing);
        switchConscious = findViewById(R.id.switchConscious);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewHealthStatus();
                saveDataHome();
                openHome();
            }
        });

//        btnHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openHome();
//            }
//        });
    }

    public void generateNewHealthStatus(){
        if(pcr.equals("Positive")){
            SelfAssessment.healthStatus = "POSITIVE";
        } else if(pcr.equals("Negative")){
            SelfAssessment.healthStatus = "NEGATIVE";
        } else {
            if(rat.equals("Positive")){
                SelfAssessment.healthStatus = "HIGH RISK";
            } else if(rat.equals("Negative")){
                SelfAssessment.healthStatus = "NEGATIVE";
            } else{
                if(switchBreathing.isChecked() || switchConscious.isChecked()){
                    SelfAssessment.healthStatus = "HIGH RISK";
                }else {
                    if (fever.equals("No") && cough.equals("No") && diarrhea.equals("No") && bodyPain.equals("No") && headache.equals("No") && lossOfSmell.equals("No")) {
                        SelfAssessment.healthStatus = "NEGATIVE";
                    } else if (fever.equals("5-10 Days") || cough.equals("5-10 Days") || diarrhea.equals("5-10 Days") || bodyPain.equals("5-10 Days") || headache.equals("5-10 Days") || lossOfSmell.equals("5-10 Days")) {
                        SelfAssessment.healthStatus = "MODERATE RISK";
                    } else if (fever.equals("1-5 Days") || cough.equals("1-5 Days") || diarrhea.equals("1-5 Days") || bodyPain.equals("1-5 Days") || headache.equals("1-5 Days") || lossOfSmell.equals("1-5 Days")) {
                        SelfAssessment.healthStatus = "LOW RISK";
                    }
                }
            }
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
        if( SelfAssessment.healthStatus.equals("POSITIVE")){
            Intent intent = new Intent(SelfAssessmentHome.this,PositiveInstructions.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "POSITIVE POSITIVE", Toast.LENGTH_SHORT).show();
        }
        else if ( SelfAssessment.healthStatus.equals("HIGH RISK")){
            Intent intent = new Intent(SelfAssessmentHome.this,HighRiskInstructions.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "High Risk", Toast.LENGTH_SHORT).show();
        }
        else if( SelfAssessment.healthStatus.equals("MODERATE RISK")){
            Intent intent = new Intent(SelfAssessmentHome.this,ModerateRiskInstructions.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "MODERATE RISK", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Already Logged In!",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SelfAssessmentHome.this, Home.class));
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SelfAssessmentHome.this,Home.class);
        startActivity(intent);

    }

}