package com.example.ui1.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ui1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegistration;

    private TextInputEditText etFullName, etAdd, etEmail, etPhone, etPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    private TextView tvLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        etFullName =  findViewById(R.id.etFullName);
        etAdd =  findViewById(R.id.etAdd);
        etEmail = findViewById(R.id.etEmail);
        etPhone =  findViewById(R.id.etPhone);
        etPassword =  findViewById(R.id.etPassword);

        tvLogIn = findViewById(R.id.tvLogIn);
        tvLogIn.setOnClickListener(this);

        btnRegistration =  findViewById(R.id.btnRegister);
        btnRegistration.setOnClickListener(this);

        progressBar = findViewById(R.id.progressBar);



    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvLogIn:
                Intent intent = new Intent(Registration.this,Login.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnRegister:
                registerUser();
                break;
        }
    }



    public void openSelfAss(){
        Intent intent = new Intent(this, SelfAssessment.class);
        startActivity(intent);
    }

    private void registerUser() {

        String fullName = etFullName.getText().toString().trim();
        String address = etAdd.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (fullName.isEmpty()){
            etFullName.setError("Field can't be empty");
            etFullName.requestFocus();
            return;
        }
        if (address.isEmpty()){
            etAdd.setError("Field can't be empty");
            etAdd.requestFocus();
            return;
        }
        if (phone.isEmpty()){
            etPhone.setError("Field can't be empty!");
            etPhone.requestFocus();
            return;
        }
        if (email.isEmpty()){
            etEmail.setError("Field can't be empty");
            etEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Enter Valid Email");
            etEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            etPassword.setError("Field can't be empty");
            etPassword.requestFocus();
            return;
        }
        if (password.length()<6){
            etPassword.setError("Password must be at least 6 characters");
            etPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user = new User(fullName, address, phone, email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                openSelfAss();
                                                Toast.makeText(Registration.this, "User has been Registered", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);
                                            }else {
                                                Toast.makeText(Registration.this, "Failed to register ! Try again!", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);
                                            }
                                        }
                                    });
                        }else{
                            Toast.makeText(Registration.this, "Failed to register! ", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
    /*@Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser()!=null){
            Toast.makeText(Registration.this,"Already Logged In!",Toast.LENGTH_SHORT).show();

            startActivity(new Intent(Registration.this, Home.class));
            finish();
        }
        else{
            Toast.makeText(Registration.this,"You can login now!",Toast.LENGTH_SHORT).show();
        }
    }*/
}