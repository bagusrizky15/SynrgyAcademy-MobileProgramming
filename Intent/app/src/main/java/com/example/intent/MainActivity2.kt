package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Bundle = intent.extras
        val iniPesan = Bundle?.getSerializable("key") as Pesan
        namaEt.setText(iniPesan.pesan)
        Log.e("CEK2", iniPesan.toString())
        btnShare.setOnClickListener(){
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                intent.getStringExtra("key")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}