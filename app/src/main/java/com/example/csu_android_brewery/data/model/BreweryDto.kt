package com.example.csu_android_brewery.data.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.csu_android_brewery.domain.models.Address
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.models.Location
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class BreweryDto(
    val id: String,
    val name: String,
    val brewery_type: String,
    val street: String,
    val address_2: String,
    val address_3: String,
    val city: String,
    val state: String,
    val county_province: String,
    val postal_code: String,
    val country: String,
    val longitude: String,
    val latitude: String,
    val phone: String,
    val website_url: String,
    val updated_at: String,
    val created_at: String
) {

    fun mapToBrewery(): Brewery {
        return Brewery(
            this.id,
            this.name,
            this.brewery_type,
            this.phone,
            this.website_url,
            )
    }

    fun mapToAddress(): Address =
        Address(
            this.id,
            this.street,
            this.address_2,
            this.address_3,
            this.city,
            this.state,
            this.county_province,
            this.postal_code,
            this.country
        )

    fun mapToLocation(): Location =
        Location(
            this.id,
            this.longitude.toFloat(),
            this.latitude.toFloat()
        )
}