package com.example.simplecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){
           Intent(this, MainActivity::class.java).also {
               sendData()
               getData()
               startActivity(intent)
           }
        }
    }

    private fun sendData() {
        val iniData = etCost.text.toString()
        intent.putExtra("input", iniData)
    }

    private fun getData() {
        var iniData = intent.getStringExtra("input")
        if (rbAmazing.isSelected){
            var total=iniData+100
            Log.e("CEK", total)

        }
        tvResult.setText(iniData)
    }
}


