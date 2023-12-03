package com.example.koinapp.data.repositories

import com.example.koinapp.data.network.DogFactApi
import com.example.koinapp.data.network.DogFactResponse

class DogFactRepositoryImpl (
    private val api: DogFactApi
): DogFactRepository {
    override suspend fun getDogFacts(): DogFactResponse? {
        val response = api.getDogFacts()
        if (response.isSuccessful) return response.body()
        else throw Exception(response.message())
    }
}