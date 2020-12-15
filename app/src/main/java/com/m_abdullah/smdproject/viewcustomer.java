package com.m_abdullah.smdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class viewcustomer extends AppCompatActivity {
    TextView done,name,email,cnic,phone,fee,joining_date;
    String namee,emaill,cnicc,feee,joining_datee,typee,img,phonee;
    CircleImageView cp_img;
    Customer cobj;
    StorageReference img_Storage;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcustomer);
        img_Storage= FirebaseStorage.getInstance().getReference();
        db=FirebaseFirestore.getInstance();
        done=findViewById(R.id.done);
        name=findViewById(R.id.v_name);
        email=findViewById(R.id.v_email);
        cnic=findViewById(R.id.v_cnic);
        phone=findViewById(R.id.v_phone);
        fee=findViewById(R.id.v_fee);
        joining_date=findViewById(R.id.v_date);
        cp_img=findViewById(R.id.v_img);



        namee=getIntent().getStringExtra("Name").toString();
        emaill=getIntent().getStringExtra("Email").toString();
        cnicc=getIntent().getStringExtra("Cnic").toString();
        typee=getIntent().getStringExtra("Type").toString();
        joining_datee=getIntent().getStringExtra("Date").toString();
        img=getIntent().getStringExtra("Image").toString();
        phonee=getIntent().getStringExtra("Phone").toString();
        typee=getIntent().getStringExtra("Type").toString();
        img_Storage=img_Storage.child("dp/"+cnicc);
        if(typee.equals("Permanet")){
            System.out.println("Hello Babes");
            feee=("800");

        }
        else if(typee.equals("Temporary")) {
            feee="1200";
            fee.setText(feee);
        }

        cp_img.setImageURI(Uri.parse(img));

        name.setText(namee);
        email.setText(emaill);
        cnic.setText(cnicc);
        phone.setText(phonee);
        fee.setText(feee);
        cnic.setText(cnicc);
        joining_date.setText(joining_datee);




        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_Storage.putFile(Uri.parse(img)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> task=taskSnapshot.getStorage().getDownloadUrl();
                        Toast.makeText(getApplicationContext(),"Uploading Please Wait!",Toast.LENGTH_SHORT).show();

                        task.addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Toast.makeText(getApplicationContext(),"Uploaded!",Toast.LENGTH_SHORT).show();
                                Map<String,Object>customer=new HashMap<>();
                                customer.put("Name",namee.toString());
                                customer.put("Email",emaill.toString());
                                customer.put("Image",uri.toString());
                                customer.put("Cnic",cnicc.toString());
                                customer.put("Phone",phonee.toString());
                                customer.put("Joinning_Date",joining_datee.toString());
                                customer.put("Type",typee.toString());
                                customer.put("Status","Paid");
                                db.collection("Users").document(cnicc.toString()).set(customer).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Date d = new Date();
                                        CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
                                        Map<String,Object> obj=new HashMap<>();
                                        obj.put("Fee","Paid");
                                        obj.put("Date", s.toString());
                                        Toast.makeText(getApplicationContext(),"User Stored Successfully",Toast.LENGTH_SHORT);
                                        finish();
                                        FirebaseFirestore db=FirebaseFirestore.getInstance();
                                        /*db.collection("Fess").document(cobj.cnic.toString()).set(obj).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    //Toast.makeText(getApplicationContext(),"Fee Created",Toast.LENGTH_SHORT).show();
                                                    //Intent it=new Intent(viewcustomer.this,addedSucessfuly.class);
                                                    //startActivity(it);
                                                    finish();
                                                }
                                            }
                                        });*/

                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }
}