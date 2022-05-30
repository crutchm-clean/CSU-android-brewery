package com.example.csu_android_brewery.presentation.DI.Modules

import com.example.csu_android_brewery.data.repositories.cloud.AddressRepository
import com.example.csu_android_brewery.data.repositories.cloud.BreweriesRepository
import com.example.csu_android_brewery.data.repositories.cloud.LocationRepository
import com.example.csu_android_brewery.domain.repositories.cloud.AddressRepo
import com.example.csu_android_brewery.domain.repositories.cloud.BreweriesRepo
import com.example.csu_android_brewery.domain.repositories.cloud.LocationsRepo
import com.example.csu_android_brewery.domain.usecases.implementations.FindBreweryUseCaseImpl
import com.example.csu_android_brewery.domain.usecases.implementations.GetBreweriesUseCaseImpl
import com.example.csu_android_brewery.domain.usecases.implementations.GetFavouritesUseCaseIml
import com.example.csu_android_brewery.domain.usecases.implementations.GetSingleItemUseCaseImpl
import com.example.csu_android_brewery.domain.usecases.interfaces.FindBreweryUseCase
import com.example.csu_android_brewery.domain.usecases.interfaces.GetBreweriesUseCase
import com.example.csu_android_brewery.domain.usecases.interfaces.GetFavouritesUseCase
import com.example.csu_android_brewery.domain.usecases.interfaces.GetSingleItemUseCase
import dagger.Binds
import dagger.Module

@Module
interface UseCasesModule {

    @Binds
    fun bindSearchUseCase(useCase: FindBreweryUseCaseImpl) : FindBreweryUseCase

    @Binds
    fun bindUpdateUseCase(useCaseIml: GetFavouritesUseCaseIml) : GetFavouritesUseCase

    @Binds
    fun bindLocationRepo(repository: LocationRepository) : LocationsRepo

    @Binds
    fun bindAddressRepo(repository: AddressRepository) : AddressRepo

    @Binds
    fun bindBreweriesRepo(repository: BreweriesRepository) : BreweriesRepo

    @Binds
    fun bindBreweriesUseCase(useCase: GetBreweriesUseCaseImpl) : GetBreweriesUseCase

    @Binds
    fun bindSimpleItemUseCase(useСase: GetSingleItemUseCaseImpl) : GetSingleItemUseCase

}