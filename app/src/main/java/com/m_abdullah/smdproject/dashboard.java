package com.m_abdullah.smdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity {
    TextView addcustomer, removecustomer,editcustomer,allcustomers,newsupdate,attendance,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        StaticClass.fill_customer(null);
        attendance=findViewById(R.id.attendance);
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(dashboard.this, attendance.class);
                startActivity(it);
            }
        });
        newsupdate=findViewById(R.id.newsupdate);
        newsupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(dashboard.this, newsupdate.class);
                startActivity(it);
            }
        });


        allcustomers=findViewById(R.id.allcustomers);
        allcustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(dashboard.this, allcustomers.class);
                startActivity(it);
            }
        });

        removecustomer=findViewById(R.id.p_fees);
        removecustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(dashboard.this, feee_paying.class);
                startActivity(it);
            }
        });
        editcustomer=findViewById(R.id.editcustomer);
        editcustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(dashboard.this, Edit_Search.class);
                startActivity(it);
            }
        });
        addcustomer=findViewById(R.id.addcustomer);
        addcustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(dashboard.this, addcustomer.class);
                startActivity(it);
            }
        });
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth mauth=FirebaseAuth.getInstance();
                mauth.signOut();
                finishAffinity();
            }
        });
    }
}