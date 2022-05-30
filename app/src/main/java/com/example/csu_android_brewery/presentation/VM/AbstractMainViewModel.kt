package com.example.csu_android_brewery.presentation.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.csu_android_brewery.domain.models.Brewery

abstract class AbstractMainViewModel : ViewModel() {
    abstract val breweries : LiveData<List<Brewery>>
    abstract val status: LiveData<Boolean>


    abstract fun refreshData()

    abstract fun addFavs(id: String)
}