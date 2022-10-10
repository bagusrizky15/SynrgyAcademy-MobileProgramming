package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navigationcomponent.databinding.FragmentSendBinding

class SendFragment : Fragment() {

    private var _binding: FragmentSendBinding? = null
    private val binding get() = _binding!!

    companion object {
        val EXTRA_PESAN = "EXTRA_PESAN"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSendBinding.inflate(inflater,container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKirim.setOnClickListener{
            val mBundle = Bundle()
            mBundle.putString(EXTRA_PESAN, "Asek asek Jos")
           // it.findNavController().navigate(R.id.sendFragment_to_receiveFragment)
        }
    }

}

