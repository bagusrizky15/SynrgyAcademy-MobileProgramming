package com.example.sqlitekotlin.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sqlitekotlin.model.DataListModel

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object{
        private val DB_NAME = "user"
        private val DB_VERSION = 1
        private val TABLE_NAME = "datauser"
        private val ID = "id"
        private val USER_NAME = "username"
        private val USER_ALAMAT = "alamat"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY,$USER_NAME TEXT, $USER_ALAMAT TEXT);"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE ="DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }

    @SuppressLint("Range")
    fun getAllData(): List<DataListModel>{
        val dataList = ArrayList<DataListModel>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor!=null){
            if (cursor.moveToFirst()){
                do {
                    val data = DataListModel()
                    data.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                    data.nama = cursor.getString(cursor.getColumnIndex(USER_NAME))
                    data.alamat = cursor.getString(cursor.getColumnIndex(USER_ALAMAT))
                    dataList.add(data)
                }while (cursor.moveToNext())
            }
        }
        cursor.close()
        return dataList
    }

    //insertdata
    fun addData(data : DataListModel) : Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(USER_NAME, data.nama)
        values.put(USER_ALAMAT, data.alamat )
        val _success = db.insert(TABLE_NAME, null)
    }

}