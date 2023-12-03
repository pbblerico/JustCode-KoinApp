package com.example.koinapp.data.di

import com.example.koinapp.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(
            get()
        )
    }
}