package com.divyanshu.assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name_id,dob_id,email_id;

    public MyAdapter(Context context, ArrayList name_id, ArrayList dob_id, ArrayList email_id) {
        this.context = context;
        this.name_id = name_id;
        this.dob_id = dob_id;
        this.email_id = email_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.data_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.dob_id.setText(String.valueOf(dob_id.get(position)));
        holder.email_id.setText(String.valueOf(email_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id,dob_id,email_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.textname);
            dob_id = itemView.findViewById(R.id.textdob);
            email_id = itemView.findViewById(R.id.textemail);
        }
    }
}
