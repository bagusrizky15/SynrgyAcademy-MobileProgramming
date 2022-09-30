package com.example.jmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var nama: TextView
    private lateinit var alamat: TextView
    private lateinit var nomor: TextView
    private lateinit var gender: TextView
    private lateinit var lokasi: TextView
    private lateinit var foto: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }
}