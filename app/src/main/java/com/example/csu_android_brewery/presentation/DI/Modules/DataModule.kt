package com.example.csu_android_brewery.presentation.DI.Modules

import android.content.Context
import androidx.room.Room
import com.example.csu_android_brewery.data.room.DataBase
import com.example.csu_android_brewery.data.room.dao.AddressDao
import com.example.csu_android_brewery.data.room.dao.BreweryDao
import com.example.csu_android_brewery.data.room.dao.LocationDao
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideDb(context: Context) : DataBase =
        Room.databaseBuilder(context, DataBase::class.java, "db").build()

    @Provides
    fun provideBreweryDao(dataBase: DataBase) : BreweryDao = dataBase.getBreweryDao()
    @Provides
    fun provideLocationDao(dataBase: DataBase) : LocationDao = dataBase.getLocationDao()
    @Provides
    fun provideAddressDao(dataBase: DataBase) : AddressDao = dataBase.getAddressDao()
}