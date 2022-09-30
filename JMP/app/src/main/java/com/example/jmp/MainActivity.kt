package com.example.jmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.jmp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var btnSubmit : Button
    private lateinit var binding : ActivityMainBinding
    private lateinit var radioGrup: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        namaFocusListener()
        phoneFocusListener()
        alamatFocusListener()

        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener{
            val jenisKelamin = radioGrup.checkedRadioButtonId
            val gender = findViewById<RadioButton>(jenisKelamin)
            
        }
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
        if (namaText.isEmpty())
        {
            return "Nama belum diisi"
        }
        return null
    }

    private fun alamatFocusListener() {
        binding.inputAlamat.setOnFocusChangeListener{_, focused ->
            if (!focused)
            {
                binding.containerAlamat.helperText = validAlamat()
            }

        }
    }

    private fun validAlamat(): String? {
        val alamatText = binding.inputNama.text.toString()
        if (alamatText.matches(".*[0-9].*".toRegex()))
        {
            return "Harus alphabet!"
        }
        if (alamatText.isEmpty())
        {
            return "Alamat belum diisi"
        }
        return null
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
        if (phoneText.isEmpty())
        {
            return "Nomor HP belum diisi"
        }
        return null
    }
}