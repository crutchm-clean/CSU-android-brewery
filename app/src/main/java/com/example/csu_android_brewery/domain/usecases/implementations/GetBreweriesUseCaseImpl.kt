package com.example.csu_android_brewery.domain.usecases.implementations

import com.example.csu_android_brewery.domain.models.Brewery
import com.example.csu_android_brewery.domain.repositories.cloud.BreweriesRepo
import com.example.csu_android_brewery.domain.usecases.interfaces.GetBreweriesUseCase
import javax.inject.Inject

class GetBreweriesUseCaseImpl @Inject constructor(private val repo: BreweriesRepo) : GetBreweriesUseCase {
    override suspend operator fun invoke(): List<Brewery> = repo.getAll()
}