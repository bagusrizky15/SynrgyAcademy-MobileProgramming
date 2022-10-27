package com.example.challengechapter4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter4.databinding.ActivityMainBinding
import com.example.challengechapter4.databinding.ItemMenuBinding

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    class ViewHolder(val itemBinding: ItemMenuBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(
            item: String
        ){
            itemBinding.textMenu.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder){
            is ViewHolder -> {
                holder.bindItem(itemList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}