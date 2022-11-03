package com.example.challengechapter4.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.challengechapter4.R
import com.example.challengechapter4.helper.PrefHelper

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var preferences: PrefHelper
    private lateinit var btnLogin: Button


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
        btnLogin = view.findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val fragment = HomeFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer, fragment)?.commit()
        }

        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {

            }
    }
}