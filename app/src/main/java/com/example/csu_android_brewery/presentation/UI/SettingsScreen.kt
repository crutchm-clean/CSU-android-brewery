package com.example.csu_android_brewery.presentation.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csu_android_brewery.R
import com.example.csu_android_brewery.databinding.ActivitySearchScreenBinding
import com.example.csu_android_brewery.databinding.ActivitySettingsScreenBinding
import com.example.csu_android_brewery.presentation.VM.AbstractFavViewModel
import com.example.csu_android_brewery.presentation.VM.AbstractMainViewModel
import com.example.csu_android_brewery.presentation.data.BreweryUi
import com.example.csu_android_brewery.presentation.factory

class SettingsScreen : AppCompatActivity() {
    private lateinit var adapter: Adapter
    private lateinit var binding: ActivitySettingsScreenBinding
    private val viewModel by viewModels<AbstractFavViewModel> { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRv()
        setRoots()
        subscribe()
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshData()
    }

    private fun subscribe() {
        viewModel.favs.observe(this) { item ->
            adapter.submitList(item.map {
                BreweryUi(it.id,
                    it.name,
                    it.isFav,
                    it.brewery_type,
                    it.phone,
                    it.website_url,
                    onClick = {
                        val intent = Intent(this, DetailScreen::class.java)
                        intent.putExtra("id", it.id)
                        startActivity(intent)
                    },
                    favsAdd = {
                        viewModel.addFavs(it.id)
                        Toast.makeText(this, "successfully removed", Toast.LENGTH_SHORT).show()
                        viewModel.refreshData()
                    })

            })
        }



    }
    private fun setRv() {
        adapter = Adapter()
        binding.RV.adapter = adapter
        binding.RV.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setRoots() {
        binding.all.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.search.setOnClickListener{
            startActivity(Intent(this, SearchScreen::class.java))
        }
    }
}