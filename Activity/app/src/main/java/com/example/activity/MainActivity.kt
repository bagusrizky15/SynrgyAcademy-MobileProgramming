package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    var x = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            x = savedInstanceState.getInt("MyInteger")
            Log.e("LIFECYCLE", "onCreate ${x}")
        }
        setContentView(R.layout.activity_main)
        }

    override fun onSaveInstanceState(outState: Bundle) {
        x = 7
        outState.putInt("MyInteger", x)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.e("LIFECYCLE", "onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.e("LIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LIFECYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LIFECYCLE", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LIFECYCLE", "onDestroy")
    }

}