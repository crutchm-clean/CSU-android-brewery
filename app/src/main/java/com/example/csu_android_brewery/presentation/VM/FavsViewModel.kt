package com.example.csu_android_brewery.presentation.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.usecases.interfaces.GetFavouritesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavsViewModel @Inject constructor(val useCase: GetFavouritesUseCase) : AbstractFavViewModel() {
    override val favs =  MutableLiveData<List<Brewery>>()

    override fun refreshData() {
        viewModelScope.launch {
            favs.value = useCase.get()
        }
    }

    override fun addFavs(id: String) {
        viewModelScope.launch {
            useCase.update(id)
            favs.value = useCase.get()
        }
    }


}