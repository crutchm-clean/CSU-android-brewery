package com.example.csu_android_brewery.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.csu_android_brewery.data.room.AddressEntity
import com.example.csu_android_brewery.data.room.LocationEntity

@Dao
interface LocationDao {
    @Insert
    suspend fun saveAll(vararg locations: LocationEntity)

    @Query("select * from LocationEntity where id=:id")
    suspend fun getOne(id: String) : List<LocationEntity>

    @Query("select * from LocationEntity")
    suspend fun getAll() : List<LocationEntity>
}