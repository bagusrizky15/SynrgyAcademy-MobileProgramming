package com.example.challengechapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    private val itemsList = ArrayList<String>()
    var adapterList = AdapterList(itemsList,  object : AdapterList.OnAdapterListener{
        override fun onClick(item: String) {
            Toast.makeText(applicationContext, item, Toast.LENGTH_SHORT).show()
            val bundle = Bundle()
            val fragment = BlankFragment()
            bundle.putString("data", "haha")
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
        }

    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView?>(R.id.recyclerView).adapter = adapterList
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager

        showList()
    }

    private fun showList() {
        for (i in 'A'..'Z')
        {
            itemsList.add("$i")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    var default = true
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            default=!default
            if (default)
            {
                item.setIcon(R.drawable.ic_span_3)
                recyclerView.layoutManager = LinearLayoutManager(this)
            }else {
                item.setIcon(R.drawable.ic_span_1)
                recyclerView.layoutManager = GridLayoutManager(this, 3)
            }
        return super.onOptionsItemSelected(item)
    }


}
