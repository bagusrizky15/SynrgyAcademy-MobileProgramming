package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_fragment.*

class MainFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        setupBottoomNav()
    }

    private fun setupBottoomNav() {
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_satu -> {
                    setupFragment(Fragment1())
                    true
                }
                R.id.navigation_dua -> {
                    setupFragment(Fragment2())
                    true
                }
                else -> throw Exception("Error")
            }
        }
    }

    private fun setupFragment(fragment1: Fragment1) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.iniFragment, fragment1)
        transaction.commit()
    }

    private fun setupFragment(fragment2: Fragment2) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.iniFragment, fragment2)
        transaction.commit()
    }
}