package com.example.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapters extends RecyclerView.Adapter<MyAdapters.CustomViewHolder> {

    private List<RetroUsers> datalist;

    public MyAdapters(List<RetroUsers> datalist) {

        this.datalist = datalist;
    }



    class CustomViewHolder extends RecyclerView.ViewHolder{

        public final View myview;

        TextView textUser;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            myview = itemView;

            textUser = itemView.findViewById(R.id.user);

        }
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.textUser.setText(datalist.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

}
