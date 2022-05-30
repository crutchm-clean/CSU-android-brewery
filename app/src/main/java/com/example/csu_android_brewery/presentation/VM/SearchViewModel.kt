package com.example.csu_android_brewery.presentation.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.usecases.interfaces.FindBreweryUseCase
import com.example.csu_android_brewery.domain.usecases.interfaces.GetFavouritesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val useCase: FindBreweryUseCase, private val fav: GetFavouritesUseCase): AbstractSearchViewModel() {
    override val breweries =  MutableLiveData<List<Brewery>>()

    override fun find(text: String) {
        viewModelScope.launch {
            breweries.value = useCase.fiind(text)
        }
    }

    override fun addFavs(id: String) {
        viewModelScope.launch {
            fav.update(id)
        }
    }
}