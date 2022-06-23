package com.example.ht5_3

import androidx.lifecycle.ViewModel

class CatViewModel: ViewModel() {

    private var currentCat = Cat()
    private val repository = CatService()
    private var favoriteCats: MutableList<Cat> = mutableListOf()

    suspend fun getCat(): Cat {
        currentCat = repository.getCats()[0]
        return currentCat
    }

    fun like() {
        favoriteCats.add(currentCat)
    }

    fun getFavoriteCats(): List<Cat> {
        return favoriteCats
    }
}
