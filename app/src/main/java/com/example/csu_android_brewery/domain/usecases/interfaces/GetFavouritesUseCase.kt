package com.example.csu_android_brewery.domain.usecases.interfaces

import com.example.csu_android_brewery.domain.models.Brewery

interface GetFavouritesUseCase {

    suspend fun get() : List<Brewery>

    suspend fun update(id : String)
}