package com.example.jmpjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    private ArrayList<Modal> userModalArrayList;
    private DBHandler dbHandler;
    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        userModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ShowActivity.this);

        userModalArrayList = dbHandler.readCourses();

        adapter = new Adapter(userModalArrayList, ShowActivity.this);
        recyclerView = findViewById(R.id.idRVData);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
    }
}