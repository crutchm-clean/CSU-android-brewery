package com.example.csu_android_brewery.domain.usecases.interfaces

import com.example.csu_android_brewery.domain.models.Brewery

interface FindBreweryUseCase {
    suspend fun fiind(text: String) : List<Brewery>
}