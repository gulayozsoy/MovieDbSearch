package com.example.moviedbsearch.di

import com.example.moviedbsearch.ui.cast.CastViewModel
import com.example.moviedbsearch.ui.detail.DetailViewModel
import com.example.moviedbsearch.ui.mainscreen.MainScreenViewModel
import com.example.moviedbsearch.ui.mainscreen.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainScreenViewModel(get())
    }
    viewModel {
        SearchViewModel(get())
    }
    viewModel {
        DetailViewModel(get())
    }
    viewModel {
        CastViewModel(get())
    }
}