package com.example.challengechapter4.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.challengechapter4.R
import com.example.challengechapter4.helper.Constant
import com.example.challengechapter4.helper.PrefHelper

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var preferences: PrefHelper
    private lateinit var btnLogin: Button
    private lateinit var tvRegister: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences = PrefHelper(requireActivity())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        var editUsername : EditText = view.findViewById(R.id.etUsername)
        var editPassword : EditText = view.findViewById(R.id.etPassword)
        tvRegister = view.findViewById(R.id.btnRegister)
        btnLogin = view.findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            preferences.put(Constant.PREF_IS_USERNAME, editUsername.text.toString())
            val fragment = HomeFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer, fragment)?.commit()
        }

        tvRegister.setOnClickListener {
            val fragment = RegisterFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer, fragment)?.commit()
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        if (preferences.getBoolean(Constant.PREF_IS_LOGIN)){
            val fragment = HomeFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer, fragment)?.commit()
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {

            }
    }
}