package com.example.finai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Registers extends AppCompatActivity {

    EditText mFullName, mEmail, mPassword, mRepeatPassword, mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Client");

        mFullName = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mRepeatPassword = findViewById(R.id.RepeatPassword);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.submit_form);
        mLoginBtn = findViewById(R.id.createText);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String username = mFullName.getText().toString().trim();
                final String email = mEmail.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();
                String repeatpassword = mRepeatPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is required");
                }

                if (password.length() < 6) {
                    mPassword.setError("Password must be >= 6 characters");
                }

                if (password != repeatpassword) {
                    mRepeatPassword.setError("Passwords do not match");
                }

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Registers.this, "User Created", Toast.LENGTH_SHORT).show();
                            SecureRandom random = new SecureRandom();
                            int num = random.nextInt(100000);
                            @SuppressLint("DefaultLocale") String formatted = String.format("%05d", num);
                            System.out.println(formatted);
                            String combine = username+formatted;
                            RegisterDatabaseHelper helper = new RegisterDatabaseHelper(combine,email,password);
                            reference.child(username+formatted).setValue(helper);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Registers.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

    }
}