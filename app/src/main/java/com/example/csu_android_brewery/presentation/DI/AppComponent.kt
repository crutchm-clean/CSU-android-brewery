package com.example.csu_android_brewery.presentation.DI

import com.example.csu_android_brewery.presentation.DI.Modules.NetworkModule
import com.example.csu_android_brewery.presentation.DI.Modules.UseCasesModule
import com.example.csu_android_brewery.presentation.DI.Modules.ViewModelModule
import dagger.Component


@Component(modules = [NetworkModule::class, UseCasesModule::class, ViewModelModule::class])
interface AppComponent {
}