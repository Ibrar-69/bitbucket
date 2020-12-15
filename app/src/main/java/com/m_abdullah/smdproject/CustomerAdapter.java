package com.m_abdullah.smdproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialog;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {
    List<Customer>ls;
    Context c;
    String context;
    CustomerAdapter(Context x, List<Customer> lss){
        c=x;
        ls=lss;
        context=c.toString();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(c).inflate(R.layout.row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    StaticClass.search_result=ls.get(position);
                    StaticClass.search_result.display();
                    Intent i=new Intent(c.getApplicationContext(),Show_Customer.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    c.startActivity(i);
                }
            });

        holder.fee.setText("Fee: "+ls.get(position).feestatus.toString());
        holder.name.setText("Name: "+ls.get(position).name.toString());
        holder.phone.setText("Contact: "+ls.get(position).phone_no);
        Picasso.get().load(Uri.parse(ls.get(position).img)).into(holder.dp);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,phone,fee;
        CircleImageView dp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.row_name);
            phone=itemView.findViewById(R.id.row_phno);
            fee=itemView.findViewById(R.id.row_fee);
            dp=itemView.findViewById(R.id.row_img);
        }
    }
}
