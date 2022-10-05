package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        klikButton()
    }

    fun klikButton(){

        btnUpload.setOnClickListener(){
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, IMAGE_REQUEST_CODE)
        }

        btnKlik.setOnClickListener(){
            val name = namaEt.text.toString()
            val intent = Intent(this, MainActivity2::class.java).also {
                it.putExtra("EXTRA_NAME", name)
                startActivity(it)
            }
    }

    }

    private fun startActivityForResult(requestCode: Int, resultCode:Int, data:Intent) {
        
    }

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }
}