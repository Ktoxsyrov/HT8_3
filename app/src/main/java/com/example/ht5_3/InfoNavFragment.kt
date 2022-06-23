package com.example.ht5_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.ht5_3.databinding.FragmentInfoNavBinding

class InfoNavFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInfoNavBinding.inflate(layoutInflater)
        binding.root.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoNavFragment_to_catNavFragment)
        }
        return binding.root
    }
}