package com.example.csu_android_brewery.data.network
import com.example.csu_android_brewery.data.model.BreweryDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {


    @GET("breweries/")
    suspend fun getAll() : List<BreweryDto>

    @GET("breweries/{obdb-id}")
    suspend fun getById(@Path("obdb-id") id: String) : BreweryDto

}