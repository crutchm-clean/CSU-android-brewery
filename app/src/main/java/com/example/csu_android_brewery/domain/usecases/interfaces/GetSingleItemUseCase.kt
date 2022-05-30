package com.example.csu_android_brewery.domain.usecases.interfaces

import com.example.csu_android_brewery.domain.models.Address
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.models.Location

interface GetSingleItemUseCase {

    suspend fun getData(id: String) : Brewery

    suspend fun getLocation(id: String) : Location

    suspend fun getAddress(id: String) : Address
}