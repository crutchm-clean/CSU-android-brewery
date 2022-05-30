package com.example.csu_android_brewery.presentation.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import  androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.csu_android_brewery.databinding.ActivityMainBinding
import com.example.csu_android_brewery.databinding.ItemBinding
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.presentation.data.BreweryUi

class Adapter : ListAdapter<BreweryUi, BreweryViewHolder>(BreweryCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder =
        BreweryViewHolder(ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))


    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

class BreweryCallBack : DiffUtil.ItemCallback<BreweryUi>(){
    override fun areItemsTheSame(oldItem: BreweryUi, newItem: BreweryUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BreweryUi, newItem: BreweryUi): Boolean {
        return oldItem == newItem
    }
}