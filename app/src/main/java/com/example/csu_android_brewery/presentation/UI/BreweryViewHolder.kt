package com.example.csu_android_brewery.presentation.UI

import android.app.Application
import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.csu_android_brewery.R
import com.example.csu_android_brewery.databinding.ActivityMainBinding
import com.example.csu_android_brewery.databinding.ItemBinding
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.presentation.data.BreweryUi

class BreweryViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BreweryUi){
        binding.breweryName.text = item.name
        binding.card.setOnClickListener{
            item.onClick()
        }
        binding.isFav.setOnClickListener{
            item.favsAdd()
        }
    }
}