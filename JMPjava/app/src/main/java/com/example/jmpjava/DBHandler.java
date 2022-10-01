package com.example.jmpjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "biodata";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "users";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAMA_COL = "nama";

    // below variable id for our course duration column.
    private static final String ALAMAT_COL = "alamat";

    // below variable for our course description column.
    private static final String NOMOR_COL = "nomor";

    // below variable is for our course tracks column.
    private static final String GENDER_COL = "gender";

    // below variable is for our course tracks column.
    private static final String LOKASI_COL = "lokasi";

    // below variable is for our course tracks column.
    private static final String GAMBAR_COL = "gambar";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAMA_COL + " TEXT,"
                + ALAMAT_COL + " TEXT,"
                + NOMOR_COL + " TEXT,"
                + LOKASI_COL + " TEXT,"
                + GAMBAR_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewData(String namaUser, String alamatUser, String nomorUser, String lokasiUser, String gambarUser) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAMA_COL, namaUser);
        values.put(ALAMAT_COL, alamatUser);
        values.put(NOMOR_COL, nomorUser);
        values.put(LOKASI_COL, lokasiUser);
        values.put(GAMBAR_COL, gambarUser);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // we have created a new method for reading all the courses.
    public ArrayList<Modal> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorData = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<Modal> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorData.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new Modal(cursorData.getString(1),
                        cursorData.getString(4),
                        cursorData.getString(2),
                        cursorData.getString(3)));
            } while (cursorData.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorData.close();
        return courseModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



}
