package com.example.ht5_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ht5_3.databinding.CatItemBinding

class FavCatAdapter: RecyclerView.Adapter<FavCatAdapter.FavCatHolder>() {


    class FavCatHolder(private val binding: CatItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(favCat: Cat){
            binding.catItemImage.setImageURI(favCat.url)
        }
    }

    private var favCats: List<Cat> = mutableListOf()

    fun setFavCatsList(favCats: List<Cat>){
        this.favCats = favCats
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavCatHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CatItemBinding.inflate(inflater, parent, false)

        return FavCatHolder(binding)
    }

    override fun onBindViewHolder(holder: FavCatHolder, position: Int) {
        holder.bind(favCats[position])
    }

    override fun getItemCount(): Int = favCats.size
}