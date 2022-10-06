package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        klikButton()
    }

    fun klikButton(){
        btnKlik.setOnClickListener(){
            val iniPesan = namaEt.text.toString()
            val bundle = Bundle()
            val message = Pesan(iniPesan)
            bundle.putSerializable("key", message)
            Log.e("CEK", iniPesan)
            Intent(this, MainActivity2::class.java).also {
                it.putExtras(bundle)
                startActivity(it)
            }
        }
    }
}