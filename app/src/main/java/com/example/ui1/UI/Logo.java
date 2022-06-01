package com.example.ui1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ui1.R;
import com.google.firebase.auth.FirebaseAuth;

public class Logo extends AppCompatActivity {
    private Button btnLogo;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        btnLogo = (Button) findViewById(R.id.btnNext);
        mAuth = FirebaseAuth.getInstance();
        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrivacy();
            }
        });
    }

    public void openPrivacy(){
        Intent intent = new Intent(this, Privacy.class);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser()!=null){
            Toast.makeText(Logo.this,"Already Logged In!",Toast.LENGTH_SHORT).show();

            startActivity(new Intent(Logo.this, Home.class));
            finish();
        }
        else{
            Toast.makeText(Logo.this,"You can login now!",Toast.LENGTH_SHORT).show();
        }
    }
}