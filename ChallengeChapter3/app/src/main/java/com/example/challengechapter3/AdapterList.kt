package com.example.challengechapter3


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter3.AdapterList.MyViewHolder

class AdapterList(
    var itemsList: List<String>,
    val listener: OnAdapterListener
    ) : RecyclerView.Adapter<MyViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemTextView.text = itemsList[position]
        holder.container.setOnClickListener{
            listener.onClick(itemsList[position])
        }

    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
        val container = view.findViewById<LinearLayout>(R.id.container)
    }

    interface OnAdapterListener {
        fun onClick(item: String)
    }


}