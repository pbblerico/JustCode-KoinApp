package com.example.koinapp.data.di

import com.example.koinapp.data.repositories.DogFactRepository
import com.example.koinapp.data.useCases.DogFactUseCaseImpl
import com.example.koinapp.data.useCases.DogFactsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        provideDogUseCase(get())
    }
}

fun provideDogUseCase(repo: DogFactRepository): DogFactsUseCase = DogFactUseCaseImpl(repo)