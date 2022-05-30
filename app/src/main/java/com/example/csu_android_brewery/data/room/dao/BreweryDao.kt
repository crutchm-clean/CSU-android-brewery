package com.example.csu_android_brewery.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.csu_android_brewery.data.room.AddressEntity
import com.example.csu_android_brewery.data.room.BreweryEntity


@Dao
interface BreweryDao {
    @Insert
    suspend fun saveAll(vararg breweries: BreweryEntity)

    @Query("select * from BreweryEntity e where e.id = :id")
    suspend fun getOne(id: String) : BreweryEntity

    @Query("update BreweryEntity set isFav = NOT isFav where id=:id")
    suspend fun updateFavs(id : String)

    @Query("select * from BreweryEntity where isFav=1")
    suspend fun getFavs() : List<BreweryEntity>

    @Query("select * from BreweryEntity")
    suspend fun getAll() : List<BreweryEntity>
}