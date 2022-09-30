package com.example.jmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jmp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        namaFocusListener()
        phoneFocusListener()
    }

    private fun namaFocusListener() {
        binding.inputNama.setOnFocusChangeListener{_, focused ->
            if (!focused)
            {
                binding.containerNama.helperText = validNama()
            }
        }
    }

    private fun validNama(): String? {
        val namaText = binding.inputNama.text.toString()
        if (namaText.matches(".*[0-9].*".toRegex()))
        {
            return "Harus alphabet!"
        }
    }

    private fun phoneFocusListener() {
        binding.inputNomor.setOnFocusChangeListener{_, focused ->
            if (!focused)
            {
                binding.containerNomor.helperText = validPhone()
            }
        }
    }

    private fun validPhone(): String? {
        val phoneText = binding.inputNomor.text.toString()
        if (phoneText.length < 10)
        {
            return "Minimal 10 nomor!"
        }
        if (!phoneText.matches(".*[0-9].*".toRegex()))
        {
            return "Harus angka!"
        }
    }
}