package com.example.csu_android_brewery.domain.usecases.interfaces

import com.example.csu_android_brewery.domain.models.Brewery

interface GetBreweriesUseCase {

    suspend operator fun invoke() : List<Brewery>
}