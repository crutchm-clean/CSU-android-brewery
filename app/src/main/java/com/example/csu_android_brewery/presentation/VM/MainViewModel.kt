package com.example.csu_android_brewery.presentation.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.usecases.interfaces.GetBreweriesUseCase
import com.example.csu_android_brewery.domain.usecases.interfaces.GetFavouritesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val breweriesUseCase: GetBreweriesUseCase,
    private val fav: GetFavouritesUseCase
) : AbstractMainViewModel() {
    override val breweries = MutableLiveData<List<Brewery>>()
    override val status = MutableLiveData<Boolean>()


    override fun refreshData() {
        viewModelScope.launch {
            status.value = true
            breweries.value = breweriesUseCase.invoke()
            status.value = false
        }
    }

    override fun addFavs(id: String) {
        viewModelScope.launch {
            fav.update(id)
        }
    }

}