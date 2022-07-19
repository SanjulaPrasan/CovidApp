package com.example.ui1.Bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ui1.R;
import com.example.ui1.UI.Home;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BluetoothActivity extends AppCompatActivity {

    private static final String TAG = "BluetoothActivity";

    BluetoothAdapter mBluetoothAdapter;
    Button btnEnableDisable_Discoverable;
    public ArrayList<BluetoothDevice> mBTDevices;
    public DeviceListAdapter mDeviceListAdapter;
    ListView lvNewDevices;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 150000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetoth);

        //Button btnONOFF = (Button) findViewById(R.id.btnONOFF);
        lvNewDevices = (ListView) findViewById(R.id.lvNewDevices);
        mBTDevices = new ArrayList<>();
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

//        btnONOFF.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: enabling/disabling bluetooth.");
//                enableDisableBT();
//            }
//        });

        startScan();
    }

//    private final BroadcastReceiver mBroadcastReceiver1 = new BroadcastReceiver() {
//        public void onReceive(Context context, Intent intent) {
//            String action = intent.getAction();
//            // When discovery finds a device
//            if (action.equals(mBluetoothAdapter.ACTION_STATE_CHANGED)) {
//                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, mBluetoothAdapter.ERROR);
//
//                switch(state){
//                    case BluetoothAdapter.STATE_OFF:
//                        Log.d(TAG, "onReceive: STATE OFF");
//                        break;
//                    case BluetoothAdapter.STATE_TURNING_OFF:
//                        Log.d(TAG, "mBroadcastReceiver1: STATE TURNING OFF");
//                        break;
//                    case BluetoothAdapter.STATE_ON:
//                        Log.d(TAG, "mBroadcastReceiver1: STATE ON");
//                        break;
//                    case BluetoothAdapter.STATE_TURNING_ON:
//                        Log.d(TAG, "mBroadcastReceiver1: STATE TURNING ON");
//                        break;
//                }
//            }
//        }
//    };
//
//
//    private final BroadcastReceiver mBroadcastReceiver2 = new BroadcastReceiver() {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            final String action = intent.getAction();
//
//            if (action.equals(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED)) {
//
//                int mode = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE, BluetoothAdapter.ERROR);
//
//                switch (mode) {
//                    //Device is in Discoverable Mode
//                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
//                        Log.d(TAG, "mBroadcastReceiver2: Discoverability Enabled.");
//                        break;
//                    //Device not in discoverable mode
//                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
//                        Log.d(TAG, "mBroadcastReceiver2: Discoverability Disabled. Able to receive connections.");
//                        break;
//                    case BluetoothAdapter.SCAN_MODE_NONE:
//                        Log.d(TAG, "mBroadcastReceiver2: Discoverability Disabled. Not able to receive connections.");
//                        break;
//                    case BluetoothAdapter.STATE_CONNECTING:
//                        Log.d(TAG, "mBroadcastReceiver2: Connecting....");
//                        break;
//                    case BluetoothAdapter.STATE_CONNECTED:
//                        Log.d(TAG, "mBroadcastReceiver2: Connected.");
//                        break;
//                }
//
//            }
//        }
//    };


    private BroadcastReceiver mBroadcastReceiver3 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            Log.d(TAG, "onReceive: ACTION FOUND.");

            if (action.equals(BluetoothDevice.ACTION_FOUND)){
                BluetoothDevice device = intent.getParcelableExtra (BluetoothDevice.EXTRA_DEVICE);
                mBTDevices.add(device);
                Log.d(TAG, "onReceive: " + device.getName() + ": " + device.getAddress());
                mDeviceListAdapter = new DeviceListAdapter(context, R.layout.device_adapter_view, mBTDevices);

                lvNewDevices.setAdapter(mDeviceListAdapter);
            }
        }
    };

//    @Override
//    protected void onDestroy() {
//        Log.d(TAG, "onDestroy: called.");
//        super.onDestroy();
//        unregisterReceiver(mBroadcastReceiver1);
//        unregisterReceiver(mBroadcastReceiver2);
//        //mBluetoothAdapter.cancelDiscovery();
//    }



//    public void enableDisableBT(){
//        if(mBluetoothAdapter == null){
//            Log.d(TAG, "enableDisableBT: Does not have BT capabilities.");
//        }
//        if(!mBluetoothAdapter.isEnabled()){
//            Log.d(TAG, "enableDisableBT: enabling BT.");
//            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivity(enableBTIntent);
//
//            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
//            registerReceiver(mBroadcastReceiver1, BTIntent);
//        }
//        if(mBluetoothAdapter.isEnabled()){
//            Log.d(TAG, "enableDisableBT: disabling BT.");
//            mBluetoothAdapter.disable();
//
//            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
//            registerReceiver(mBroadcastReceiver1, BTIntent);
//        }
//
//    }
    private void startScan() {

        View v= this.findViewById(android.R.id.content);
        btnDiscover(v);
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, delay);
                Toast.makeText(BluetoothActivity.this, "Scanning",
                        Toast.LENGTH_SHORT).show();
                mBTDevices.clear();
                btnDiscover(v);
            }
        }, delay);
    }

    public void btnDiscover(View view) {
        Log.d(TAG, "btnDiscover: Looking for unpaired devices.");

        if(mBluetoothAdapter.isDiscovering()){
            mBluetoothAdapter.cancelDiscovery();
            Log.d(TAG, "btnDiscover: Canceling discovery.");

            //check BT permissions in manifest
            checkBTPermissions();

            mBluetoothAdapter.startDiscovery();
            IntentFilter discoverDevicesIntent = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(mBroadcastReceiver3, discoverDevicesIntent);
        }
        if(!mBluetoothAdapter.isDiscovering()){

            //check BT permissions in manifest
            checkBTPermissions();

            mBluetoothAdapter.startDiscovery();
            IntentFilter discoverDevicesIntent = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(mBroadcastReceiver3, discoverDevicesIntent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    private void checkBTPermissions() {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            int permissionCheck = this.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
            permissionCheck += this.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION");
            if (permissionCheck != 0) {

                this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1001); //Any number
            }
        }else{
            Log.d(TAG, "checkBTPermissions: No need to check permissions. SDK version < LOLLIPOP.");
        }
    }
}