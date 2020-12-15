package com.m_abdullah.smdproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class allcustomers extends AppCompatActivity {
    RecyclerView rv;
    CustomerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcustomers);
        rv=findViewById(R.id.rv);
        adapter=new CustomerAdapter(getApplicationContext(),StaticClass.c_array);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        StaticClass.fill_customer(adapter);
        adapter.notifyDataSetChanged();


    }
}