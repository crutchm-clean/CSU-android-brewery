package com.example.csu_android_brewery.presentation.DI.Modules

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class AppModule(private val context: Context) {
    @Provides
    fun context() = context
}