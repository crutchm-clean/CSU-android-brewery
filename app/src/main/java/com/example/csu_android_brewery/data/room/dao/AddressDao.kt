package com.example.csu_android_brewery.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.csu_android_brewery.data.room.AddressEntity
import com.example.csu_android_brewery.domain.models.Address

@Dao
interface AddressDao {
    @Insert
    suspend fun saveAll(vararg address: AddressEntity)

    @Query("select * from AddressEntity e where e.id= :id")
    suspend fun getOne(id: String) : AddressEntity

    @Query("select * from AddressEntity")
    suspend fun getAll() : List<AddressEntity>

}