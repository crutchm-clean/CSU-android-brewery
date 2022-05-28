package com.example.csu_android_brewery.presentation.DI.Modules

import androidx.lifecycle.ViewModelProvider
import com.example.csu_android_brewery.presentation.DI.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}