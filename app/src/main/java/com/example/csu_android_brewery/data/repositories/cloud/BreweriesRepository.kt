package com.example.csu_android_brewery.data.repositories.cloud

import com.example.csu_android_brewery.data.network.Api
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.repositories.cloud.BreweriesRepo
import javax.inject.Inject

open class BreweriesRepository @Inject constructor(private val api : Api) : BreweriesRepo {

    override suspend fun getAll(): List<Brewery> {
        val result = mutableListOf<Brewery>()
        api.getAll().forEach{
            result.add(it.mapToBrewery())
        }
        return result
    }

    override suspend fun getById(id: String): Brewery = api.getById(id).mapToBrewery()

}