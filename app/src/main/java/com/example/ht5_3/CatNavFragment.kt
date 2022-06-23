package com.example.ht5_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.example.ht5_3.databinding.FragmentCatNavBinding
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CatNavFragment : Fragment() {

    private lateinit var catViewModel: CatViewModel
    private lateinit var binding: FragmentCatNavBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatNavBinding.inflate(layoutInflater)
        Fresco.initialize(requireContext())
        catViewModel = ViewModelProvider(this)[CatViewModel::class.java]
        getImage()

        binding.likeButton.setOnClickListener {
            catViewModel.like()
            getImage()
            binding.likeButton.isClickable = false
        }

        binding.dislikeButton.setOnClickListener {
            getImage()
        }



        binding.favoritesButton.setOnClickListener {
            requireFragmentManager().beginTransaction().
            replace(R.id.containerForFavs,FavoritesFragment(catViewModel.getFavoriteCats()))
                .commit()
//
//            it.findNavController().navigate(R.id.action_catNavFragment_to_favCatsNavFragment)

        }

        binding.infoButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_catNavFragment_to_infoNavFragment)
        }

        return binding.root
    }
    private fun getImage(){
        CoroutineScope(Job()).launch {
            binding.catImage.setImageURI(catViewModel.getCat().url.toUri())
            binding.likeButton.isClickable = true
        }
    }
}