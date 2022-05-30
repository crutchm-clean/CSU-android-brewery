package com.example.csu_android_brewery.domain.repositories.cloud

import com.example.csu_android_brewery.domain.models.Brewery

interface BreweriesRepo : BaseRepo<Brewery> {
    suspend fun getFavs() : List<Brewery>

    suspend fun updateFavs(id: String)
}