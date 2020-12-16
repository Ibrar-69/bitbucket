package com.m_abdullah.smdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class addedSucessfuly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_sucessfuly);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        },3000);
    }
}