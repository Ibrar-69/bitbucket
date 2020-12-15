package com.m_abdullah.smdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class attendance_customer extends AppCompatActivity {
    TextView name,email,cnic,phone,feestatus;
    CircleImageView dp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_customer);
        name=findViewById(R.id.at_name);
        email=findViewById(R.id.at_email);
        cnic=findViewById(R.id.at_cnic);
        phone=findViewById(R.id.at_phone);
        dp=findViewById(R.id.at_img);
        feestatus=findViewById(R.id.at_fee);

        Customer cobj=StaticClass.search_result;
        name.setText(cobj.name.toString());
        email.setText(cobj.email.toString());
        cnic.setText(cobj.cnic.toString());
        phone.setText(cobj.phone_no.toString());
        feestatus.setText(cobj.feestatus);

        Picasso.get().load(Uri.parse(cobj.img)).into(dp);

    }
}