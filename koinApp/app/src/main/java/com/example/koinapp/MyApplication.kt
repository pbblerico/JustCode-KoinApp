package com.example.koinapp

import android.app.Application
import com.example.koinapp.data.di.networkModule
import com.example.koinapp.data.di.repositoryModule
import com.example.koinapp.data.di.useCaseModule
import com.example.koinapp.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }

}