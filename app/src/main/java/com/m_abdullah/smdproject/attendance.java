package com.m_abdullah.smdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class attendance extends AppCompatActivity {
    TextView newsbar,Cnic;
    Button search_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        newsbar=findViewById(R.id.attendence_newsbar);
        newsbar.setText("Hello Ibrar");
        Cnic=findViewById(R.id.attendence_cnic);
        search_btn=findViewById(R.id.attendence_search);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(Cnic.getText().toString())){
                    Cnic.setError("Cnic is Required");
                    return;
                }

                if(Cnic.getText().toString().length()<13 ||Cnic.getText().toString().length()>13 ){
                    Cnic.setError("13 Digit cnic Required");
                    return;
                }


                Customer cobj=StaticClass.get_customer(Cnic.getText().toString());
                if(cobj!=null){
                    System.out.println("We Found It");
                    Intent i=new Intent(getApplicationContext(),attendance_customer.class);
                    startActivity(i);
                }
                else if(cobj==null){
                    System.out.println("Not Found");
                }

            }
        });

    }
}