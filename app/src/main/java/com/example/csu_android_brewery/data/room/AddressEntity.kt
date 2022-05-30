package com.example.csu_android_brewery.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AddressEntity(
    @PrimaryKey val id: String,
    val street: String?,
    val address_2: String?,
    val address_3: String?,
    val city: String,
    val state: String,
    val county_province: String?,
    val postal_code: String,
    val country: String,
)
