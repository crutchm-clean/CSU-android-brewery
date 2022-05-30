package com.example.csu_android_brewery.data.repositories.cloud

import com.example.csu_android_brewery.data.network.Api
import com.example.csu_android_brewery.data.room.BreweryEntity
import com.example.csu_android_brewery.data.room.dao.BreweryDao
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.repositories.cloud.BreweriesRepo
import javax.inject.Inject

open class BreweriesRepository @Inject constructor(private val api: Api, val dao: BreweryDao) :
    BreweriesRepo {
    override suspend fun getFavs(): List<Brewery> {
        return dao.getFavs().map {
            Brewery(
                it.id,
                it.name,
                it.isFav,
                it.brewery_type,
                it.phone,
                it.website_url
            )
        }
    }

    override suspend fun updateFavs(id: String) {
        dao.updateFavs(id)
    }

    override suspend fun getAll(): List<Brewery> {
        val fromDb = dao.getAll()
        if (fromDb.isNotEmpty()) {
            return fromDb.map {
                Brewery(
                    it.id,
                    it.name,
                    it.isFav,
                    it.brewery_type,
                    it.phone,
                    it.website_url
                )
            }
        } else {
            val fromApi = api.getAll()
            val mapped = fromApi.map {
                BreweryEntity(
                    it.id,
                    it.name,
                    false,
                    it.brewery_type,
                    it.phone,
                    it.website_url
                )
            }
            dao.saveAll(*mapped.toTypedArray())
            return fromApi.map{it.mapToBrewery()}
        }
    }

    override suspend fun getById(id: String): Brewery {
        val list = dao.getAll()
        var a = list[0]
        list.forEach{
            if(it.id == id){
                a = it
            }
        }
        return Brewery(
            a.id,
            a.name,
            a.isFav,
            a.brewery_type,
            a.phone,
            a.website_url
        )
    }

}