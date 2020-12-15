package com.m_abdullah.smdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class updatecustomer extends AppCompatActivity {
    Spinner spinner;
    TextView next;
    EditText name,email,phone,cnic;
    DatePicker dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatecustomer);
        spinner=findViewById(R.id.uc_spinner);
        name=findViewById(R.id.uc_name);
        email=findViewById(R.id.uc_email);
        phone=findViewById(R.id.uc_phone);
        cnic=findViewById(R.id.uc_cnic);
        dp=findViewById(R.id.uc_date_picker);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(updatecustomer.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.types));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}