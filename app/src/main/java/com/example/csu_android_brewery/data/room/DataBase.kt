package com.example.csu_android_brewery.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.csu_android_brewery.data.room.dao.AddressDao
import com.example.csu_android_brewery.data.room.dao.BreweryDao
import com.example.csu_android_brewery.data.room.dao.LocationDao


@Database(
    entities = [
        AddressEntity::class,
        BreweryEntity::class,
        LocationEntity::class
    ],
    version = 1
)

abstract class DataBase : RoomDatabase() {
    abstract fun getAddressDao(): AddressDao
    abstract fun getBreweryDao(): BreweryDao
    abstract fun getLocationDao(): LocationDao
}