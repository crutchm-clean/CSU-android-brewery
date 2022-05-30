package com.example.csu_android_brewery.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class LocationEntity(@PrimaryKey val id: String, val longitude : Float?, val latitude: Float?)
