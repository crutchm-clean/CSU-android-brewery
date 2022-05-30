package com.example.csu_android_brewery.data.repositories.cloud

import com.example.csu_android_brewery.data.network.Api
import com.example.csu_android_brewery.data.room.LocationEntity
import com.example.csu_android_brewery.data.room.dao.LocationDao
import com.example.csu_android_brewery.domain.models.Location
import com.example.csu_android_brewery.domain.repositories.cloud.LocationsRepo
import javax.inject.Inject

class LocationRepository @Inject constructor(val api: Api, val dao: LocationDao) : LocationsRepo {

    override suspend fun getAll(): List<Location> {
        val fromDb = dao.getAll()
        if(fromDb.isNotEmpty()){
            return fromDb.map{
                Location(
                    it.id,
                    it.longitude,
                    it.latitude
                )
            }
        } else{
            val fromApi = api.getAll()
            val mapped = fromApi.map {
                LocationEntity(
                    it.id,
                    it.longitude?.toFloat(),
                    it.latitude?.toFloat()

                )
            }
            dao.saveAll(*mapped.toTypedArray())
            return fromApi.map { it.mapToLocation() }
        }
    }

    override suspend fun getById(id: String): Location {
        val list = dao.getAll()
        var a = list[0]
        list.forEach{
            if(it.id == id){
                a = it
            }
        }
        return Location(
            a.id,
            a.longitude,
            a.latitude
        )
    }
}