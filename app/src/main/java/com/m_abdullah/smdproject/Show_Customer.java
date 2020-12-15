package com.m_abdullah.smdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Show_Customer extends AppCompatActivity {
    TextView done,name,email,cnic,phone,fee,joining_date;
    String namee,emaill,cnicc,feee,joining_datee,typee,img,phonee;
    CircleImageView cp_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__customer);
        done=findViewById(R.id.done);
        name=findViewById(R.id.v_name);
        email=findViewById(R.id.v_email);
        cnic=findViewById(R.id.v_cnic);
        phone=findViewById(R.id.v_phone);
        fee=findViewById(R.id.v_fee);
        joining_date=findViewById(R.id.v_date);
        cp_img=findViewById(R.id.v_img);

        namee=StaticClass.search_result.name.toString();
        emaill=StaticClass.search_result.email.toString();
        cnicc=StaticClass.search_result.cnic.toString();
        phonee=StaticClass.search_result.phone_no.toString();
        feee=StaticClass.search_result.feestatus.toString();
        joining_datee=StaticClass.search_result.joining_date.toString();
        Picasso.get().load((Uri.parse(StaticClass.search_result.img))).into(cp_img);

        name.setText(namee);
        email.setText(emaill);
        cnic.setText(cnicc);
        phone.setText(phonee);
        fee.setText(feee);
        joining_date.setText(joining_datee);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db=FirebaseFirestore.getInstance();
                db.collection("Users").document(StaticClass.search_result.cnic.toString()).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(),"Wait Please!",Toast.LENGTH_SHORT);
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Customer Deleted",Toast.LENGTH_SHORT).show();
                            StaticClass.c_array.remove(StaticClass.search_result);
                            StaticClass.search_result=null;
                           new AlertDialog.Builder(getApplicationContext()).setTitle("SuccessFull").setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            }).show();


                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Error Occured",Toast.LENGTH_SHORT);
                        }
                    }
                });
            }
        });

    }
}