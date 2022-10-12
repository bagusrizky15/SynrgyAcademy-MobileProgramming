package com.example.challengechapter3

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter3.AdapterList.MyViewHolder

class AdapterList(
    var itemsList: List<String>
    ) : RecyclerView.Adapter<MyViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemTextView.text = itemsList[position]
        holder.itemTextView.setOnClickListener{
            Log.e("CEK", itemsList[position])
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
    }
}