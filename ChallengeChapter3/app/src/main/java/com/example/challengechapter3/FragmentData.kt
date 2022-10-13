package com.example.challengechapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_data.*

class FragmentData : Fragment() {
    private lateinit var tvFragment: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_data, container, false)
        tvFragment = view.findViewById(R.id.textFragment)
        val data = arguments
        tvFragment.text = data!!.get("string").toString()
        return view
    }
}