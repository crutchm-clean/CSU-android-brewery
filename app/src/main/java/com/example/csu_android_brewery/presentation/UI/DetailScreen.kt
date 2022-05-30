package com.example.csu_android_brewery.presentation.UI

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.example.csu_android_brewery.R
import com.example.csu_android_brewery.databinding.ActivityDetailScreenBinding
import com.example.csu_android_brewery.domain.models.Address
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.models.Location
import com.example.csu_android_brewery.presentation.VM.AbstractDetailViewModel
import com.example.csu_android_brewery.presentation.VM.AbstractMainViewModel
import com.example.csu_android_brewery.presentation.factory
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import java.nio.file.Files.move

class DetailScreen : AppCompatActivity() {
    private lateinit var id: String
    private lateinit var binding: ActivityDetailScreenBinding
    private val viewModel by viewModels<AbstractDetailViewModel> { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        id = intent.getStringExtra("id").toString()
        subscribe()
    }

    @SuppressLint("SetTextI18n")
    private fun setMapData(loc: Location) {
        if(loc.longitude == null){
            binding.status.visibility = View.VISIBLE

            binding.status.text = "Location is unavailable"
        } else {
            binding.status.visibility = View.VISIBLE
            binding.status.text = "https://maps.google.com?saddr=Current+Location&daddr=${loc.latitude},${loc.longitude}"

        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshData(id)
    }



    private fun subscribe() {
        viewModel.brewery.observe(this) {
            setBreweryData(it)
        }
        viewModel.address.observe(this) {
            setAddressData(it)
        }
        viewModel.location.observe(this) {
            setMapData(it)
        }
        viewModel.loadStatus.observe(this) {
            controlProgressBar(it)
        }
    }

    private fun setAddressData(item: Address) {
        binding.city.text = "City " + item.city
        if (item.street == null) {
            binding.street.text = "Street data is uavailable"
        } else {
            binding.street.text = "Street: " + item.street
        }
        binding.state.text = "State: " + item.state

    }

    private fun setBreweryData(item: Brewery) {
        binding.type.text = "Type: " + item.brewery_type
        if(item.phone == null){
            binding.phone.text = "Phone is unavailable"
        } else{
            binding.phone.text = "Phone: " + item.phone
        }
        binding.site.text = "Url: " + item.website_url
    }

    private fun controlProgressBar(status: Boolean) {
        if (status) {
            binding.status.visibility = View.VISIBLE
            binding.pb.visibility = View.VISIBLE
        } else {
            binding.pb.visibility = View.INVISIBLE
        }
    }
}