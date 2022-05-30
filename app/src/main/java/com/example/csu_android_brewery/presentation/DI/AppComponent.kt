package com.example.csu_android_brewery.presentation.DI

import com.example.csu_android_brewery.presentation.DI.Modules.*
import com.example.csu_android_brewery.presentation.VM.ViewModelFactory
import dagger.Component


@Component(modules = [AppModule::class, NetworkModule::class, UseCasesModule::class, ViewModelModule::class, DataModule::class])
interface AppComponent {
    fun factory() : ViewModelFactory
}