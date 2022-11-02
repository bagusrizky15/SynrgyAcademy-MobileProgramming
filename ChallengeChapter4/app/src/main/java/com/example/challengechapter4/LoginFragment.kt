package com.example.challengechapter4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.challengechapter4.helper.PrefHelper

class LoginFragment : Fragment(R.layout.fragment_login) {

    lateinit var preferences: PrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences = PrefHelper(this)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
        
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {

            }
    }
}