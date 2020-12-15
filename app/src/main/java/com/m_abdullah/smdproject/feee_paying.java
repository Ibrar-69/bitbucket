package com.m_abdullah.smdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.Var;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class feee_paying extends AppCompatActivity {
    EditText cnic;
    Button pay_fee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feee_paying);
        cnic=findViewById(R.id.fee_cnic);
        pay_fee=findViewById(R.id.fee_pay);
        pay_fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore dbb=FirebaseFirestore.getInstance();
                Customer cobj=StaticClass.get_customer(cnic.getText().toString());
                if(cobj!=null){
                    Date d = new Date();
                    CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
                    Map<String,Object> obj=new HashMap<>();
                    obj.put("Fee","Paid");
                    obj.put("Date", s.toString());
                    FirebaseFirestore db=FirebaseFirestore.getInstance();
                           db.collection("Fess").document(cobj.cnic.toString()).update(obj).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Updated Fee",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}