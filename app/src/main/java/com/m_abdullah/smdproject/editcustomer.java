package com.m_abdullah.smdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class editcustomer extends AppCompatActivity {
    TextView name,email,cnic,phone,usertype,fee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcustomer);
        name=findViewById(R.id.ec_name);
        email=findViewById(R.id.ec_email);
        cnic=findViewById(R.id.ec_phone);
        phone=findViewById(R.id.ec_phone);
        usertype=findViewById(R.id.ec_usertype);
        fee=findViewById(R.id.ec_fee);
    }
}