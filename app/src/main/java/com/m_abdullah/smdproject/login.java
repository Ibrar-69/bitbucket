package com.m_abdullah.smdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    TextView login;
    EditText email;
    EditText password;
    FirebaseAuth maauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        email=findViewById(R.id.login_Email);
        password=findViewById(R.id.login_password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maauth=FirebaseAuth.getInstance();
                maauth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent it=new Intent(login.this, dashboard.class);
                            startActivity(it);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Incorrect Email Or Password",Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });
    }
}
