package com.m_abdullah.smdproject;

import android.os.Build;
import android.text.format.DateFormat;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public  class StaticClass {
    public static  Customer search_result;
    public static List<Customer>c_array=new ArrayList<>();

    public static void fill_customer(final CustomerAdapter adapter){
       FirebaseFirestore db= FirebaseFirestore.getInstance();
       db.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
           @RequiresApi(api = Build.VERSION_CODES.KITKAT)
           @Override
           public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if(task.isSuccessful()){
                c_array.clear();
                List<DocumentSnapshot>docs= Objects.requireNonNull(task.getResult()).getDocuments();
                for(int i=0;i<docs.size();i++){
                    Map<String,Object>obj=docs.get(i).getData();
                    Customer cobj=new Customer();
                    cobj.name=obj.get("Name").toString();
                    cobj.user_type=obj.get("Type").toString();
                    cobj.phone_no=obj.get("Phone").toString();
                    cobj.joining_date=obj.get("Joinning_Date").toString();
                    cobj.email=obj.get("Email").toString();
                    cobj.cnic=obj.get("Cnic").toString();
                    cobj.img=obj.get("Image").toString();
                    cobj.feestatus="Paid";
                    c_array.add(cobj);
                }

                if(adapter!=null){
                    add_fee();
                    adapter.notifyDataSetChanged();
                }

            }
           }
       });

    }
    public static Customer get_customer(String cnic){
        for(int i=0;i<c_array.size();i++){
            if(c_array.get(i).cnic.equals(cnic)){
                search_result=c_array.get(i);
                return c_array.get(i);
            }
        }
        search_result=null;
        return null;
    }
    public static void update_fee(){
        Date d = new Date();
        CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
        String date=s.toString();
        String[]parts=date.split(",");
        String part2=parts[0];
        parts=part2.split(" ");
        part2=parts[1].toString();
        if(part2.equals("15")){
            FirebaseFirestore db= FirebaseFirestore.getInstance();
            db.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        FirebaseFirestore firestore=FirebaseFirestore.getInstance();

                        List<DocumentSnapshot>docs= Objects.requireNonNull(task.getResult()).getDocuments();
                        for(int i=0;i<docs.size();i++){
                            Map<String,Object>obj=docs.get(i).getData();
                            Customer cobj=new Customer();
                            cobj.name=obj.get("Name").toString();
                            cobj.user_type=obj.get("Type").toString();
                            cobj.phone_no=obj.get("Phone").toString();
                            cobj.joining_date=obj.get("Joinning_Date").toString();
                            cobj.email=obj.get("Email").toString();
                            cobj.cnic=obj.get("Cnic").toString();
                            cobj.img=obj.get("Image").toString();
                            cobj.feestatus="Paid";
                            Date d = new Date();
                            CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
                            Map<String,Object> objj=new HashMap<>();
                            obj.put("Fee","Not_Paid");
                            obj.put("Date", s.toString());
                            firestore.collection("Fess").document(cobj.cnic.toString()).update(objj);

                        }


                    }
                }
            });
        }

    }
    public static void add_fee(){
        FirebaseFirestore db= FirebaseFirestore.getInstance();
        db.collection("Fess").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    List<DocumentSnapshot>docs= Objects.requireNonNull(task.getResult()).getDocuments();
                    for(int i=0;i<docs.size();i++){
                        Map<String,Object>obj=docs.get(i).getData();
                       c_array.get(i).feestatus=obj.get("Fee").toString();
                    }
                }
            }
        });
    }
}
