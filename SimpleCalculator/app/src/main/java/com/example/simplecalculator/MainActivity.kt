package com.example.simplecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){
           Intent(this, MainActivity::class.java).also {
               sendData()
               getData()
               totalResult()
               startActivity(intent)
           }
        }

        radioGroup.
    }

    private fun totalResult() {
        if (etCost.text.isEmpty())
        {
            tvResult.text = "0"
            return
        } else {

        }
    }

    private fun sendData() {
        val iniData = etCost.text.toString()
        intent.putExtra("input", iniData)
    }

    private fun getData() {
        val iniData = intent.getStringExtra("input")
        tvResult.setText(iniData)
    }
}


