package com.example.jmpjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Modal> courseModalArrayList;
    private Context context;

    public Adapter(ArrayList<Modal> userModalArrayList, ShowActivity showActivity) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Modal modal = courseModalArrayList.get(position);
        holder.userName.setText(modal.getNamaUser());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView userName;
        public ViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);

        }
    }
}
