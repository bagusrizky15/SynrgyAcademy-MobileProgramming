package com.example.challengechapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val itemsList = ArrayList<String>()
    private lateinit var adapterList: AdapterList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        adapterList = AdapterList(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapterList
        showList()
    }

    private fun showList() {
        val itmarray = arrayListOf<String>('A'.toString(), 'B'.toString())
        for (i in 1..itmarray.size)
        {
            itemsList.add(itmarray.size[i])
        }
        adapterList.notifyDataSetChanged()
    }


}