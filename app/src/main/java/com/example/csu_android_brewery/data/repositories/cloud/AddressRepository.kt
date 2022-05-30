package com.example.csu_android_brewery.data.repositories.cloud

import com.example.csu_android_brewery.data.network.Api
import com.example.csu_android_brewery.data.room.AddressEntity
import com.example.csu_android_brewery.data.room.BreweryEntity
import com.example.csu_android_brewery.data.room.dao.AddressDao
import com.example.csu_android_brewery.domain.models.Address
import com.example.csu_android_brewery.domain.repositories.cloud.AddressRepo
import javax.inject.Inject

class AddressRepository @Inject constructor(val api: Api, val dao: AddressDao) : AddressRepo {
    override suspend fun getAll(): List<Address> {
        val fromDb = dao.getAll()
        if (fromDb.isNotEmpty()) {
            return fromDb.map {
                Address(
                    it.id,
                    it.street,
                    it.address_2,
                    it.address_3,
                    it.city,
                    it.state,
                    it.county_province,
                    it.postal_code,
                    it.country
                )
            }
        } else{
            val fromApi = api.getAll()
            val mapped = fromApi.map {
                AddressEntity(
                    it.id,
                    it.street,
                    it.address_2,
                    it.address_3,
                    it.city,
                    it.state,
                    it.county_province,
                    it.postal_code,
                    it.country)
            }
            dao.saveAll(*mapped.toTypedArray())
            return fromApi.map { it.mapToAddress() }
        }
    }

    override suspend fun getById(id: String): Address {
        val list = dao.getAll()
        var fromDb = list[0]
        list.forEach{
            if(it.id == id){
                fromDb = it
            }
        }
        return Address(
            fromDb.id,
            fromDb.street,
            fromDb.address_2,
            fromDb.address_3,
            fromDb.city,
            fromDb.state,
            fromDb.county_province,
            fromDb.postal_code,
            fromDb.country
        )
    }
}