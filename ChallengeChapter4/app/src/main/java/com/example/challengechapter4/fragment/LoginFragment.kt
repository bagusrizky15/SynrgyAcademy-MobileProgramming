package com.example.challengechapter4.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.challengechapter4.R
import com.example.challengechapter4.helper.Constant
import com.example.challengechapter4.helper.PrefHelper

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var preferences: PrefHelper
    private lateinit var btnLogin: Button
    lateinit var username: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences = PrefHelper(requireActivity())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

        btnLogin.setOnClickListener{
            if (username.text.isNotEmpty()){
                preferences.put(Constant.PREF_IS_USERNAME, username.text.toString())
                preferences.put(Constant)
            }
        }

    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {

            }
    }
}