package com.example.koinapp.data.repositories

import com.example.koinapp.data.network.DogFactResponse

interface DogFactRepository {
    suspend fun getDogFacts(): DogFactResponse?
}