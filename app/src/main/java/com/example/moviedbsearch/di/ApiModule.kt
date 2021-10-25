package com.example.moviedbsearch.di

import com.example.moviedbsearch.network.MoviesApiInterface
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideApi(retrofit: Retrofit): MoviesApiInterface {
        return retrofit.create( MoviesApiInterface::class.java)
    }
    single { provideApi(get()) }

}