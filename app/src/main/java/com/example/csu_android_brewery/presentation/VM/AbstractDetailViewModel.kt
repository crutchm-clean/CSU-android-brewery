package com.example.csu_android_brewery.presentation.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.csu_android_brewery.domain.models.Address
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.models.Location

abstract class AbstractDetailViewModel : ViewModel() {
    abstract val brewery : LiveData<Brewery>
    abstract val location : LiveData<Location>
    abstract val address: LiveData<Address>
    abstract val loadStatus: LiveData<Boolean>

    abstract fun refreshData(id: String)
}