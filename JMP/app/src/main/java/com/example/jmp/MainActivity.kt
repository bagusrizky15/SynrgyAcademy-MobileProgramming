package com.example.jmp

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.app.ActivityCompat
import com.example.jmp.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.w3c.dom.Text
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    //deklarasi variabel
    private lateinit var btnSubmit : Button
    private lateinit var btnShow: Button
    private lateinit var binding : ActivityMainBinding
    private lateinit var nama: TextView
    private lateinit var alamat: TextView
    private lateinit var nomor: TextView
    private lateinit var radioGrup: RadioGroup
    private lateinit var mFusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //inisialisasi location service
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        //validasi
        namaFocusListener()
        phoneFocusListener()
        alamatFocusListener()
        val context = this

        nama = findViewById(R.id.inputNama)
        alamat = findViewById(R.id.inputAlamat)
        nomor = findViewById(R.id.inputNomor)
        radioGrup = findViewById(R.id.radioGrup)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnShow = findViewById(R.id.btnShow)
        btnSubmit.setOnClickListener{
            val jenisKelamin = radioGrup.checkedRadioButtonId
            val gender = findViewById<RadioButton>(jenisKelamin)

            if (nama.text.toString().length>0 &&
                    alamat.text.toString().length>0){
                var user = User(nama.text.toString(),alamat.text.toString())
                var db = DataBaseHandler(context)
                db.insertData(user)
            }
        }
    }

    //cek lokasi
    private fun isLocationEnabled(): Boolean {
        val locationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    //cek permission
    private fun checkPermissions(): Boolean{
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCES_COARSE_LOCATION)
        == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            == PackageManager.PERMISSION_GRANTED
        ){
            return true
        }
        return false
    }

    //validasi nama
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

    //validasi alamat
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

    //validasi nomor
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