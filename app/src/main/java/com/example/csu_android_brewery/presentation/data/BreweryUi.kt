package com.example.csu_android_brewery.presentation.data

import android.content.Context
import com.example.csu_android_brewery.domain.models.Brewery

data class BreweryUi (
    val id: String,
    val name: String,
    val isFav: Boolean,
    val brewery_type: String,
    val phone: String?,
    val website_url: String?,
    val onClick: () -> Unit,
    val favsAdd: () -> Unit
)