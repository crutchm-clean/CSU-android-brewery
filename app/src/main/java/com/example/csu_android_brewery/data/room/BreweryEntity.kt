package com.example.csu_android_brewery.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BreweryEntity(
    @PrimaryKey val id: String,
    val name: String,
    val isFav: Boolean,
    val brewery_type: String,
    val phone: String?,
    val website_url: String?,
)
