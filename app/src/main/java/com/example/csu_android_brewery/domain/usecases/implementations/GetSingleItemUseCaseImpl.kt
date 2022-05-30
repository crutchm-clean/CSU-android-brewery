package com.example.csu_android_brewery.domain.usecases.implementations

import com.example.csu_android_brewery.domain.models.Address
import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.models.Location
import com.example.csu_android_brewery.domain.repositories.cloud.AddressRepo
import com.example.csu_android_brewery.domain.repositories.cloud.BreweriesRepo
import com.example.csu_android_brewery.domain.repositories.cloud.LocationsRepo
import com.example.csu_android_brewery.domain.usecases.interfaces.GetSingleItemUseCase
import javax.inject.Inject

class GetSingleItemUseCaseImpl @Inject constructor(val repo: BreweriesRepo, val aRepo: AddressRepo, val lRepo: LocationsRepo) : GetSingleItemUseCase {

    override suspend fun getData(id: String): Brewery {
        repo.getAll()
        return repo.getById(id)
    }

    override suspend fun getLocation(id: String): Location {
        lRepo.getAll()
        return lRepo.getById(id)
    }

    override suspend fun getAddress(id: String): Address {
        aRepo.getAll()
        return aRepo.getById(id)
    }


}