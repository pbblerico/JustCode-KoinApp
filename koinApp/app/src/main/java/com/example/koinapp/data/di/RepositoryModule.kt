package com.example.koinapp.data.di

import com.example.koinapp.data.network.DogFactApi
import com.example.koinapp.data.repositories.DogFactRepository
import com.example.koinapp.data.repositories.DogFactRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        provideDogFactRepository(get())
    }
}

fun provideDogFactRepository(api: DogFactApi): DogFactRepository = DogFactRepositoryImpl(api)