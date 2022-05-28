package com.example.csu_android_brewery.presentation

import android.app.Application
import com.example.csu_android_brewery.presentation.DI.AppComponent
import com.example.csu_android_brewery.presentation.DI.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}