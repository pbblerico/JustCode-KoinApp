package com.example.koinapp.data.useCases

import com.example.koinapp.data.network.DogFactResponse
import com.example.koinapp.data.repositories.DogFactRepository

class DogFactUseCaseImpl (
    private val repo: DogFactRepository
): DogFactsUseCase {
    override suspend fun execute(): DogFactResponse? {
        return repo.getDogFacts()
    }

}