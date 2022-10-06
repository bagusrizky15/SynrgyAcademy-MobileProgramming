package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        klikButton()
    }

    fun klikButton(){

        btnUpload.setOnClickListener(){
            val intent = packageManager.getLaunchIntentForPackage("com.google.android.youtube")
            if (intent !=null){
                startActivity(intent)
            }else{
                Toast.makeText(this, "aplikasi tidak ada", Toast.LENGTH_SHORT).show()
            }
        }

        btnKlik.setOnClickListener(){
            val name = namaEt.text.toString()
            val intent = Intent(this, MainActivity2::class.java).also {
                it.putExtra("EXTRA_NAME", name)
                startActivity(it)
            }
    }

    }


}