package com.example.jmpjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    FusedLocationProviderClient fusedLocationProviderClient;
    TextView lokasi, lokasiAlamat;
    Button getLocation;

    TextView namaUser, alamatUser, nomorUser;
    Button getSubmit;
    private final static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaUser = findViewById(R.id.inputNama);
        alamatUser = findViewById(R.id.inputAlamat);
        nomorUser = findViewById(R.id.inputNomor);
        getSubmit = findViewById(R.id.btnSubmit);

        getSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = namaUser.getText().toString();
                String address = alamatUser.getText().toString();
                String phone = nomorUser.getText().toString();
                
                boolean check = validateinfo(name,address,phone);

                if (check==true){
                    Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Sorry repeat again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lokasi = findViewById(R.id.tvLokasi);
        lokasiAlamat = findViewById(R.id.tvLokasiAlamat);
        getLocation = findViewById(R.id.btnLocation);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLastLocation();
            }
        });
    }

    private Boolean validateinfo(String name, String address, String phone) {
        if (name.length()==0){
            namaUser.requestFocus();
            namaUser.setError("Nama tidak boleh kosong");
            return false;
        }
        else if (!name.matches("[a-zA-Z]+"))
        {
            namaUser.setError("Nama harus Alphabet");
        }
        else if (!address.matches("[a-zA-Z]+"))
        {
            alamatUser.setError("Nama harus Alphabet");
        }
        else if (address.length()==0){
            alamatUser.requestFocus();
            alamatUser.setError("Alamat tidak boleh kosong");
        }
        else if (phone.length()==0){
            nomorUser.requestFocus();
            nomorUser.setError("Nomor hp tidak boleh kosong");
        }
        else if (!phone.matches("[0-9]{10,13}$")){
            nomorUser.requestFocus();
            nomorUser.setError("Format yang benar 08xxxxxx");
        }
        else {
            return true;
        }
    }


    //get location gmaps
    private void getLastLocation() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null){
                                try {
                                    Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),1);
                                    lokasi.setText("Address: "+addresses.get(0).getAddressLine(0));
                                    lokasiAlamat.setText("City: "+addresses.get(0).getLocality());
                                } catch (IOException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    });

        }else {
            askPermission();
        }
    }

    private void askPermission() {
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {

        if (requestCode == REQUEST_CODE){

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){


                getLastLocation();

            }else {


                Toast.makeText(MainActivity.this,"Please provide the required permission",Toast.LENGTH_SHORT).show();

            }



        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}