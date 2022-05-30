package com.example.csu_android_brewery.presentation.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.csu_android_brewery.domain.models.Brewery

abstract class AbstractFavViewModel : ViewModel() {
    abstract val favs : LiveData<List<Brewery>>

    abstract fun refreshData()

    abstract fun addFavs(id: String)
}