package com.example.csu_android_brewery.domain.usecases.implementations

import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.repositories.cloud.BreweriesRepo
import com.example.csu_android_brewery.domain.usecases.interfaces.GetFavouritesUseCase
import javax.inject.Inject

class GetFavouritesUseCaseIml @Inject constructor(val repo: BreweriesRepo) : GetFavouritesUseCase {
    override suspend fun get(): List<Brewery> {
        return repo.getFavs()
    }

    override suspend fun update(id: String) {
        repo.updateFavs(id)
    }
}