package com.example.csu_android_brewery.domain.usecases.implementations

import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.repositories.cloud.BreweriesRepo
import com.example.csu_android_brewery.domain.usecases.interfaces.FindBreweryUseCase
import javax.inject.Inject

class FindBreweryUseCaseImpl @Inject constructor(val repo: BreweriesRepo) : FindBreweryUseCase {
    override suspend fun fiind(text: String) : List<Brewery> {
        var res = mutableListOf<Brewery>()
        repo.getAll().forEach{
            if(it.name.toLowerCase().contains(text.toLowerCase())){
                res.add(it)
            }
        }
        return res
    }

}