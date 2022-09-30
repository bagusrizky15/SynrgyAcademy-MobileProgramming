package com.example.jmp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "formDaftar"
val TABLE_NAME = "Users"
val COL_NAME = "nama"
val COL_ALAMAT = "alamat"
val COL_NOMOR = "nomor"
val COL_LOKASI = "lokasi"
val COL_FOTO ="foto"
val COL_ID = "id"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null ,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," +
                COL_ALAMAT + " VARCHAR(256)," +
                COL_LOKASI + " VARCHAR(256)," +
                COL_FOTO + " VARCHAR(256)," +
                COL_NOMOR +" INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user : User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,user.nama)
        cv.put(COL_ALAMAT,user.alamat)
        var result = db.insert(TABLE_NAME,null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Gagal Menambah Data",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Berhasil Menambah Data",Toast.LENGTH_SHORT).show()
    }

    fun readData() : MutableList<User>{
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * FROM" + TABLE_NAME
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()){
            do {

            }while (result)
        }

        result.close()
        db.close()
        return list
    }

}