package com.m_abdullah.smdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class customersearch extends AppCompatActivity {
    EditText cnic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customersearch);
        cnic=findViewById(R.id.cs_cnic);
    }
}