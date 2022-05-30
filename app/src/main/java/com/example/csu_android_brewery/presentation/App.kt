package com.example.csu_android_brewery.presentation

import android.app.Application
import com.example.csu_android_brewery.R
import com.example.csu_android_brewery.presentation.DI.AppComponent
import com.example.csu_android_brewery.presentation.DI.DaggerAppComponent
import com.example.csu_android_brewery.presentation.DI.Modules.AppModule
import com.yandex.mapkit.MapKitFactory

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(getString(R.string.api_key))
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this)).build()

    }
}