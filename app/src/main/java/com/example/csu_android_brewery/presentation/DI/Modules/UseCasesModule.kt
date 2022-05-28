package com.example.csu_android_brewery.presentation.DI.Modules

import com.example.csu_android_brewery.data.repositories.cloud.BreweriesRepository
import com.example.csu_android_brewery.domain.repositories.cloud.BreweriesRepo
import com.example.csu_android_brewery.domain.usecases.implementations.GetBreweriesUseCaseImpl
import com.example.csu_android_brewery.domain.usecases.interfaces.GetBreweriesUseCase
import dagger.Binds
import dagger.Module

@Module
interface UseCasesModule {

    @Binds
    fun bindBreweriesRepo(repository: BreweriesRepository) : BreweriesRepo

    @Binds
    fun bindBreweriesUseCase(useCase: GetBreweriesUseCaseImpl) : GetBreweriesUseCase

}