package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var costService: TextView
    private lateinit var rb: RadioGroup
    private lateinit var tip: Switch
    private lateinit var totalResult: TextView
    private lateinit var buttonCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        costService = findViewById(R.id.cost_of_service)
        rb = findViewById(R.id.radioGroup)
        tip = findViewById(R.id.round_up_switch)
        totalResult = findViewById(R.id.tvResult)
        buttonCalculate = findViewById(R.id.calculate_button)

        buttonCalculate.setOnClickListener{
            val selectedRadioButton: Int = rb.checkedRadioButtonId
            
        }
    }
}


