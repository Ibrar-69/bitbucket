package com.m_abdullah.smdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Edit_Search extends AppCompatActivity {
    EditText cnic;
    TextView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__search);
        cnic=findViewById(R.id.cs_cnic);
        search=findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Customer cobj=StaticClass.get_customer(cnic.getText().toString());
                if(cobj!=null){
                    System.out.println("We Found It");
                    Intent i=new Intent(getApplicationContext(),Update_Customer_Details.class);
                    startActivity(i);
                }
                else if(cobj==null){
                    System.out.println("Not Found");
                }

            }
        });
    }
}