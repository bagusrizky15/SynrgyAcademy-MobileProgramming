package com.example.jmpjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int lok = 0;
    FusedLocationProviderClient fusedLocationProviderClient;
    TextView lokasi, lokasiAlamat;
    Button getLocation;

    DBHandler dbHandler;

    TextView namaUser, alamatUser, nomorUser;
    Button getSubmit, getShow;

    RadioButton rbL,rbP;
    RadioGroup rGrup;
    private final static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbL = findViewById(R.id.rbLaki);
        rbP = findViewById(R.id.rbPerempuan);
        rGrup = findViewById(R.id.radioGrup);
        //gambarUser = findViewById(R.id.btnUpload)
        namaUser = findViewById(R.id.inputNama);
        alamatUser = findViewById(R.id.inputAlamat);
        nomorUser = findViewById(R.id.inputNomor);
        getSubmit = findViewById(R.id.btnSubmit);
        getShow = findViewById(R.id.btnShow);

        dbHandler = new DBHandler(MainActivity.this);

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

        getSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = namaUser.getText().toString();
                String address = alamatUser.getText().toString();
                String phone = nomorUser.getText().toString();
                String locate = lokasi.getText().toString();
                String locate2 = lokasiAlamat.getText().toString();

                boolean check = validateinfo(name,address,phone);

                if (check==true){
                    dbHandler.addNewData(name, address, phone, locate, locate2);
                    Toast.makeText(MainActivity.this, "Data berhasil ditambah", Toast.LENGTH_SHORT).show();
                    namaUser.setText("");
                    alamatUser.setText("");
                    nomorUser.setText("");
                    lokasiAlamat.setText("");

                }
                else {
                    Toast.makeText(getApplicationContext(), "Isi semua data", Toast.LENGTH_SHORT).show();
                }


            }
        });

        getShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(i);
            }
        });

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
                                    lok ++;
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

    private Boolean validateinfo(String name, String address, String phone) {
        if (name.length()==0){
            namaUser.requestFocus();
            namaUser.setError("Nama tidak boleh kosong");
            return false;
        }
        else if (!name.matches("[a-zA-Z]+"))
        {
            namaUser.requestFocus();
            namaUser.setError("Nama harus Alphabet");
            return false;
        }
        else if (address.length()==0){
            alamatUser.requestFocus();
            alamatUser.setError("Alamat tidak boleh kosong");
            return false;
        }
        else if (!address.matches("[a-zA-Z]+"))
        {
            alamatUser.requestFocus();
            alamatUser.setError("Alamat harus Alphabet");
            return false;
        }
        else if (phone.length()==0){
            nomorUser.requestFocus();
            nomorUser.setError("Nomor hp tidak boleh kosong");
            return false;
        }
        else if (!phone.matches("[0-9]{10,13}$")){
            nomorUser.requestFocus();
            nomorUser.setError("Format yang benar 08xxxxxx");
            return false;
        }
        else if (!rbL.isChecked() && !rbP.isChecked()){
            rGrup.requestFocus();
            Toast.makeText(getApplicationContext(), "Pilih gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!(lok ==0)){
            getLocation.requestFocus();
            Toast.makeText(getApplicationContext(), "Cek Lokasi dulu", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
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