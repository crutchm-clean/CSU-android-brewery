package com.example.csu_android_brewery.presentation.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.csu_android_brewery.domain.models.Address
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.models.Location
import com.example.csu_android_brewery.domain.usecases.interfaces.GetSingleItemUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(val useCase: GetSingleItemUseCase) : AbstractDetailViewModel(){

    override val address = MutableLiveData<Address>()
    override val loadStatus =  MutableLiveData<Boolean>()

    override val location = MutableLiveData<Location>()
    override val brewery = MutableLiveData<Brewery>()

    override  fun refreshData(id: String) {
        viewModelScope.launch {
            address.value = useCase.getAddress(id)
            brewery.value = useCase.getData(id)
            loadStatus.value = true
            location.value = useCase.getLocation(id)
            loadStatus.value = false

        }
    }


}