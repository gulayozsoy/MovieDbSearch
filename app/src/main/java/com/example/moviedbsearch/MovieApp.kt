package com.example.moviedbsearch

import android.app.Application
import com.example.moviedbsearch.di.apiModule
import com.example.moviedbsearch.di.networkModule
import com.example.moviedbsearch.di.repositoryModule
import com.example.moviedbsearch.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MovieApp)
            modules(
                listOf(
                    apiModule,
                    viewModelModule,
                    repositoryModule,
                    networkModule
                )
            )
        }
    }
}