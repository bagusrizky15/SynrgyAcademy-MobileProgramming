package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var costService: TextView
    private lateinit var rb: RadioGroup
    private lateinit var tip: SwitchCompat
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
            if (selectedRadioButton != -1)
            {
                Toast.makeText(applicationContext, "Dipilih", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(applicationContext, "Tidak dipilih", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


