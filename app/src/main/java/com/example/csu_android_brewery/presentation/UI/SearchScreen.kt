package com.example.csu_android_brewery.presentation.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csu_android_brewery.R
import com.example.csu_android_brewery.databinding.ActivitySearchScreenBinding
import com.example.csu_android_brewery.presentation.VM.AbstractMainViewModel
import com.example.csu_android_brewery.presentation.VM.AbstractSearchViewModel
import com.example.csu_android_brewery.presentation.data.BreweryUi
import com.example.csu_android_brewery.presentation.factory

class SearchScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySearchScreenBinding
    private lateinit var adapter: Adapter
    private val viewModel by viewModels<AbstractSearchViewModel> { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRv()
        subscribe()
        setNav()
        setSearch()
    }

    private fun setSearch() {
        binding.tvName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.find(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun setNav() {
        binding.all.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.settings.setOnClickListener{
            startActivity(Intent(this, SettingsScreen::class.java))
        }
    }

    private fun subscribe() {
        viewModel.breweries.observe(this ) { item ->
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

    private fun setRv() {
        adapter = Adapter()
        binding.RV.adapter = adapter
        binding.RV.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}