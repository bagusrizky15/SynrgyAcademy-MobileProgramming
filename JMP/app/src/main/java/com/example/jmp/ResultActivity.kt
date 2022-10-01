package com.example.jmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val namaUser = findViewById(R.id.outputNama)

        val db = DataBaseHandler(this,null)
        val cursor = db.getData()

        cursor!!.moveToFirst()
        namaUser.append(cursor.getString(cursor.getColumnIndex(DataBaseHandler.COL_NAME)) + "\n")

        // moving our cursor to next
        // position and appending values
        while(cursor.moveToNext()){
            namaUser.append(cursor.getString(cursor.getColumnIndex(DataBaseHandler.COL_NAME)) + "\n")
        }

        // at last we close our cursor
        cursor.close()

    }
}