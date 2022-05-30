package com.example.csu_android_brewery.presentation.UI

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csu_android_brewery.R
import com.example.csu_android_brewery.databinding.ActivityMainBinding
import com.example.csu_android_brewery.presentation.VM.AbstractMainViewModel
import com.example.csu_android_brewery.presentation.VM.ViewModelFactory
import com.example.csu_android_brewery.presentation.data.BreweryUi
import com.example.csu_android_brewery.presentation.factory
import java.util.jar.Manifest
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: Adapter
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<AbstractMainViewModel> { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        subscribe()
        setMenu()
    }

    private fun setMenu() {
        binding.search.setOnClickListener{
            startActivity(Intent(this, SearchScreen::class.java))
        }
        binding.settings.setOnClickListener{
            startActivity(Intent(this, SettingsScreen::class.java))
        }
    }


    override fun onResume() {
        super.onResume()
        viewModel.refreshData()
    }

    private fun subscribe() {
        viewModel.breweries.observe(this) { item ->
            adapter.submitList(item.map {
                BreweryUi(it.id, it.name, it.isFav, it.brewery_type, it.phone, it.website_url, onClick = {
                    val intent = Intent(this, DetailScreen::class.java)
                    intent.putExtra("id", it.id)
                    startActivity(intent)
                },
                    favsAdd = {
                        viewModel.addFavs(it.id)
                        Toast.makeText(this, "successfully added", Toast.LENGTH_SHORT).show()
            })

            })
        }
    }


    private fun setAdapter() {
        adapter = Adapter()
        binding.RV.adapter = adapter
        binding.RV.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}