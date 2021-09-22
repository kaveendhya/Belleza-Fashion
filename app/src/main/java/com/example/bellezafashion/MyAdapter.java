package com.example.bellezafashion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Designer> list;

    public MyAdapter(Context context, ArrayList<Designer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.desiglist,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {

        Designer designer=list.get(position);
        holder.tvlistid.setText(designer.getDesignerID());
        holder.tvlistname.setText(designer.getDesignerName());
        holder.tvlistocc.setText(designer.getOccupation());
        holder.tvlistmail.setText(designer.getEmail());
        holder.listphone.setText(designer.getPhone().toString());
        holder.tvlistcost.setText(designer.getCost().toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvlistid,tvlistname,tvlistocc,tvlistmail,listphone,tvlistcost;

        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);

            tvlistid = itemView.findViewById(R.id.tvlistid);
            tvlistname = itemView.findViewById(R.id.tvlistname);
            tvlistocc =itemView.findViewById(R.id.tvlistname);
            tvlistmail = itemView.findViewById(R.id.tvlistmail);
            listphone = itemView.findViewById(R.id.listphone);
            tvlistcost = itemView.findViewById(R.id.tvlistcost);

        }
    }
}
