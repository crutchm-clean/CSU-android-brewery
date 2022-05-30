package com.example.csu_android_brewery.domain.models

import java.time.LocalDate
import java.util.*

data class Brewery(
    val id: String,
    val name: String,
    val isFav: Boolean,
    val brewery_type: String,
    val phone: String?,
    val website_url: String?,
)
