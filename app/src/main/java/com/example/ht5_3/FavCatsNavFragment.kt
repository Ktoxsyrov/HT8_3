package com.example.ht5_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ht5_3.databinding.FragmentFavoritesBinding

class FavCatsNavFragment(favCatsList: List<Cat>) : Fragment() {
    private val favList = favCatsList
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFavoritesBinding.inflate(layoutInflater)
        val adapter = FavCatAdapter()
        adapter.setFavCatsList(favList)
        binding.favoritesRecycler.adapter = adapter
        binding.favoritesRecycler.layoutManager = LinearLayoutManager(requireContext())
        println(favList.size)
        binding.backToFeedButton.setOnClickListener {
            fragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
        return binding.root

    }
}