package com.example.ui1.UI;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ui1.Bluetooth.BluetoothActivity;
import com.example.ui1.Models.ContactModel;
import com.example.ui1.R;
import com.example.ui1.SQLite.DbHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private TextView status;
    VideoView videoView;

    private Button btnStats;
    private  Button btnSelfAss;
    private Button btnProf;
    public static String health;

    public static final int REQUEST_ENABLE_BLUETOOTH = 11;
    private static final String TAG = "BluetoothActivity";
    BluetoothAdapter mBluetoothAdapter;
    public ArrayList<BluetoothDevice> mBTDevices;
    Handler handler = new Handler();
    Runnable runnable;
    int delay = 15000;

    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        status = findViewById(R.id.tvStatusValue);

        SharedPreferences sharedPreferences = getSharedPreferences(SelfAssessment.SHARED_PREFS, MODE_PRIVATE);
        health = sharedPreferences.getString(SelfAssessment.TEXT, "");

        status.setText("" + health);

        this.videoView = findViewById(R.id.vvBlueScan);
        this.videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.blue_scan2));
        MediaController videoControl = new MediaController(this);
        videoControl.setAnchorView(this.videoView);
        //this.videoView.setMediaController(videoControl);
        this.videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });


        btnStats = (Button) findViewById(R.id.btnStats);
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStats();
            }
        });
        btnSelfAss = (Button) findViewById(R.id.btnSelfAss);
        btnSelfAss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelfAss();
            }
        });
        btnProf = (Button) findViewById(R.id.btnProf);
        btnProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProf();
            }
        });

        mBTDevices = new ArrayList<>();
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        dbHandler = new DbHandler(Home.this);
        checkBluetoothState();
        startScan();
    }

    public void openStats(){
        Intent intent = new Intent(this, Stats.class);
        startActivity(intent);
    }
    public void openSelfAss(){
        Intent intent = new Intent(this, SelfAssessmentHome.class);
        startActivity(intent);
    }
    public void openProf(){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }


    @Override
    protected void onPostResume() {
        videoView.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart() {
        videoView.start();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        videoView.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        videoView.stopPlayback();
        super.onDestroy();
    }

    private BroadcastReceiver mBroadcastReceiver3 = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            Log.d(TAG, "onReceive: ACTION FOUND.");

            if (action.equals(BluetoothDevice.ACTION_FOUND)){
                BluetoothDevice device = intent.getParcelableExtra (BluetoothDevice.EXTRA_DEVICE);
                mBTDevices.add(device);
                Log.d(TAG, "onReceive: " + device.getName() + ": " + device.getAddress());
                String address  = device.getAddress();
                addToDatabase(address);
            }
        }
    };


    private void startScan() {

        View v= this.findViewById(android.R.id.content);
        btnDiscover(v);
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, delay);
                Toast.makeText(Home.this, "Scanning",
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

    @SuppressLint("MissingPermission")
    private void checkBluetoothState() {
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "NOT supported", Toast.LENGTH_LONG).show();
        }
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BLUETOOTH);
        }
        else if( mBluetoothAdapter.isEnabled()){
            Toast.makeText(this, "Bluetooth is already turned on", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
        }
        else {
            Toast.makeText(this, "Need to turn on Bluetooth", Toast.LENGTH_LONG).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addToDatabase(String mac_Address){

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate now = LocalDate.now();
        ContactModel contactModel= new ContactModel(mac_Address,now);

        dbHandler.addContactData(contactModel);
        Toast.makeText(Home.this,"Close Contacts Added",Toast.LENGTH_LONG).show();
        removeFromDatabase();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void removeFromDatabase(){

        int i = dbHandler.removeData();
        if (i>0) {
            Log.d(TAG, "removeFromDatabase:" + "Old data removed");
        }
        else
            Toast.makeText(Home.this, "failed ", Toast.LENGTH_LONG).show();
    }
}