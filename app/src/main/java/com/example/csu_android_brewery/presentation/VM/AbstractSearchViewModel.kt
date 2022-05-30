package com.example.csu_android_brewery.presentation.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.csu_android_brewery.domain.models.Brewery

abstract class AbstractSearchViewModel : ViewModel() {
    abstract val breweries : LiveData<List<Brewery>>

    abstract fun find(text: String)

    abstract fun addFavs(id: String)
}