package com.m_abdullah.smdproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class Update_Customer_Details extends AppCompatActivity {
    Spinner spinner;
    TextView next;
    CircleImageView cimg;
    EditText name, email, phone;
    DatePicker dp;
    Uri img_uri;
    Calendar calend;
    final static int GALLERY_REQUEST_CODE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__customer__details);
        spinner = findViewById(R.id.spinner);
        name = findViewById(R.id.ac_name);
        email = findViewById(R.id.ac_email);
        phone = findViewById(R.id.ac_phone);
        dp = findViewById(R.id.ac_date_picker);
        cimg = findViewById(R.id.addcustomerimg);

        cimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_REQUEST_CODE);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.types));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("Name is Required");
                    return;
                }
                if(TextUtils.isEmpty(email.getText().toString())){
                    email.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(phone.getText().toString())){
                    phone.setError("Phone is Required");
                    return;
                }

                if(phone.getText().toString().length()<11 ||phone.getText().toString().length()>11 ){
                    phone.setError("03xx, 7 Digit Phone No Required");
                    return;
                }



                Date d = new Date();
                CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
                Intent it = new Intent(getApplicationContext(), viewcustomer.class);
                it.putExtra("Name",name.getText().toString());
                it.putExtra("Email",email.getText().toString());
                it.putExtra("Cnic",StaticClass.search_result.cnic.toString());
                it.putExtra("Phone",phone.getText().toString());
                it.putExtra("Date",s.toString());
                it.putExtra("Type",spinner.getSelectedItem().toString());
                it.putExtra("Image",img_uri.toString());
                System.out.println(spinner.getSelectedItem().toString());
                startActivity(it);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            System.out.println("Entered Into Space");
            img_uri = data.getData();
            cimg.setImageURI(img_uri);


        } else {

        }
    }
}