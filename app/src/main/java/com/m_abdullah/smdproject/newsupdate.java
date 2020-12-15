package com.m_abdullah.smdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class newsupdate extends AppCompatActivity {
    TextView newsupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsupdate);
        newsupdate=findViewById(R.id.nu_newupdate);
    }
}