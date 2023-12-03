package com.example.koinapp.data.di

import com.example.koinapp.data.network.DogFactApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        getRetrofit()
    }
    single {
        getDogsApi(get())
    }
}

private fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://dog-api.kinduff.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun getDogsApi(retrofit: Retrofit): DogFactApi {
    return retrofit.create(DogFactApi::class.java)
}