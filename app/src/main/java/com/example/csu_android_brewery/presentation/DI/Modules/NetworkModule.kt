package com.example.csu_android_brewery.presentation.DI.Modules

import com.example.csu_android_brewery.common.Endpoints
import com.example.csu_android_brewery.data.network.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkModule {
    @Provides
    fun provideApi() : Api{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Endpoints.base)
            .build()
        return retrofit.create()
    }
}