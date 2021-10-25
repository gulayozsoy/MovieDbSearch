package com.example.moviedbsearch.di


import com.example.moviedbsearch.network.MoviesApiInterface
import com.example.moviedbsearch.repository.MoviesRepository
import com.example.moviedbsearch.repository.MoviesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    fun provideRepository(api: MoviesApiInterface): MoviesRepository {
        return MoviesRepositoryImpl(api)
    }
    single { provideRepository(get()) }
}