package com.example.csu_android_brewery.domain.models

data class Address(
    val id: String,
    val street: String,
    val address_2: String,
    val address_3: String,
    val city: String,
    val state: String,
    val county_province: String,
    val postal_code: String,
    val country: String,
)
