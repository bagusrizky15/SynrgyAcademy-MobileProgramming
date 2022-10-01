package com.example.jmp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.*
import androidx.constraintlayout.motion.widget.Debug.getLocation
import androidx.core.app.ActivityCompat
import com.example.jmp.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.w3c.dom.Text
import java.util.*
import android.Manifest;

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
    private val permissionId = 2

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //inisialisasi location service
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        binding.btnLocation.setOnClickListener {
            getLocation()
        }

        //validasi
        namaFocusListener()
        phoneFocusListener()
        alamatFocusListener()
        val context = this

        nama = findViewById(R.id.inputNama) as EditText
        alamat = findViewById(R.id.inputAlamat) as EditText
        nomor = findViewById(R.id.inputNomor) as EditText
        radioGrup = findViewById(R.id.radioGrup) as RadioGroup
        btnSubmit = findViewById(R.id.btnSubmit) as Button
        btnShow = findViewById(R.id.btnShow) as Button

        btnSubmit.setOnClickListener{
            val jenisKelamin = radioGrup.checkedRadioButtonId
            val gender = findViewById<RadioButton>(jenisKelamin)

            if (nama.text.toString().length>0 &&
                alamat.text.toString().length>0 &&
                nomor.text.toString().length>0 ){
                var user = User(nama.text.toString(),alamat.text.toString(),nomor.text.toString())
                var db = DataBaseHandler(context)
                db.insertData(user)
            }

        }

        btnShow.setOnClickListener{

            val intent = Intent(this, ResultActivity::class.java).also {
                startActivity(intent)
            }
        }
    }


    //cek lokasi
    private fun isLocationEnabled(): Boolean {
        val locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    //cek permission
    private fun checkPermissions(): Boolean{
        if (ActivityCompat.checkSelfPermission(
                this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
        ){
            return true
        }
        return false
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            permissionId
        )
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == permissionId) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getLocation()
            }
        }
    }

    @SuppressLint("MissingPermission", "SetTextI18n")
    private fun getLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
                    val location: Location? = task.result
                    if (location != null) {
                        val geocoder = Geocoder(this, Locale.getDefault())
                        val list: List<Address> =
                            geocoder.getFromLocation(location.latitude, location.longitude, 1)
                        binding.apply {
                            tvLokasi.text = "Locality\n${list[0].locality}"
                            tvLokasiAlamat.text = "Address\n${list[0].getAddressLine(0)}"
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Please turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }
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