package com.example.csu_android_brewery.domain.repositories.cloud

interface BaseRepo<T> {
    suspend fun getAll() : List<T>

    suspend fun getById(id: String) : T

}