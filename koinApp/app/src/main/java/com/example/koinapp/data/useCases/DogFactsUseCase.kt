package com.example.koinapp.data.useCases

import com.example.koinapp.data.network.DogFactResponse

interface DogFactsUseCase {
    suspend fun execute(): DogFactResponse?
}