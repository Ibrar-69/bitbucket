package com.m_abdullah.smdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class dashboard extends AppCompatActivity {
    TextView addcustomer, removecustomer,editcustomer,allcustomers,newsupdate,attendance,logout,news;
    FirebaseFirestore firedb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        StaticClass.fill_customer(null);
        news=findViewById(R.id.newsbar);
        firedb=FirebaseFirestore.getInstance();
        firedb.collection("News").document("news").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot snap=task.getResult();
                    news.setText(snap.get("news").toString());
                    news.setSelected(true);
                }
            }
        });
        //news.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        //news.setText("Hello Welcome To Stay Fit and we welcome you here hope you enjoy");

       // news.setSingleLine(true);
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

    @Override
    protected void onResume() {
        super.onResume();
        firedb=FirebaseFirestore.getInstance();
        firedb.collection("News").document("news").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot snap=task.getResult();
                    news.setText(snap.get("news").toString());
                    news.setSelected(true);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firedb=FirebaseFirestore.getInstance();
        firedb.collection("News").document("news").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot snap=task.getResult();
                    news.setText(snap.get("news").toString());
                    news.setSelected(true);
                }
            }
        });
    }
}