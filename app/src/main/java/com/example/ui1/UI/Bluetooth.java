package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ui1.R;

public class Bluetooth extends AppCompatActivity {
    private Button btnBluetooth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        btnBluetooth = findViewById(R.id.btnNext);
        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGetStarted();
            }
        });
    }

    public void openGetStarted(){
        Intent intent = new Intent(this, Start.class);
        startActivity(intent);
    }
}