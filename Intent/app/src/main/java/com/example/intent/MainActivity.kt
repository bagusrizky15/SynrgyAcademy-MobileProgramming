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
            bundle.putString("NAMA", iniPesan)
            Log.e("CEK", iniPesan)
            val i = Intent(this, MainActivity2::class.java).also {
                intent.putExtras(bundle)
                startActivity(it)
            }
        }
    }
}