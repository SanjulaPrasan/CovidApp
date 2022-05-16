package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ui1.R;

public class Bluetooth extends AppCompatActivity {
    /*private Button btnBluetooth;
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
    }*/




    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;

    private BluetoothAdapter mblueAdapter;
    private Button btnBluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        btnBluetooth = findViewById(R.id.btnNext);
        mblueAdapter = BluetoothAdapter.getDefaultAdapter();


        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mblueAdapter.isEnabled()){
                    showToast("Turning on Bluetooth ...");
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent,REQUEST_ENABLE_BT);
                    Intent i=new Intent(Bluetooth.this, Start.class);
                    startActivity(i);

                }else{
                    showToast("Bluetooth is already on .....");
                    Intent i=new Intent(Bluetooth.this, Start.class);
                    startActivity(i);
                }

            }
        });
    }

    private void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}