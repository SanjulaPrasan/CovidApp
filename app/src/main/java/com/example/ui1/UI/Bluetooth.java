package com.example.ui1.UI;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ui1.R;

public class Bluetooth extends AppCompatActivity {
    public static final int REQUEST_ACCESS_COARSE_LOCATION = 1;
    public static final int REQUEST_ENABLE_BLUETOOTH = 11;

    private BluetoothAdapter bluetoothAdapter;
    private Button btnBluetooth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        btnBluetooth = findViewById(R.id.btnNext);
        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBluetoothState();
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void checkBluetoothState() {
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "NOT supported", Toast.LENGTH_LONG).show();
        }
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BLUETOOTH);
        }
        else if( bluetoothAdapter.isEnabled()){
            Toast.makeText(this, "Bluetooth is already turned on", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,Start.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Intent intent = new Intent(this,Start.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Need to turn on Bluetooth", Toast.LENGTH_LONG).show();
        }
    }
}