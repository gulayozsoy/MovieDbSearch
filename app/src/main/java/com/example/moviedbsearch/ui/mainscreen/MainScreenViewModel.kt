package com.example.moviedbsearch.ui.mainscreen

import androidx.lifecycle.*
import com.example.moviedbsearch.model.Movies
import com.example.moviedbsearch.model.SearchResult
import com.example.moviedbsearch.repository.MoviesRepository
import com.example.moviedbsearch.util.Constants.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel(private val repository: MoviesRepository): ViewModel() {

    private val _popularMovieList = MutableLiveData<List<Movies>>()
    val popularMovieList: LiveData<List<Movies>> = _popularMovieList


    private val _loadingVisible = MutableLiveData(false)
    val loadingVisible: LiveData<Boolean> get() = _loadingVisible

    fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingVisible.postValue(true)
            try {
                val list = repository.getPopularMovies(API_KEY, "en-US",1)
                if (list != null) {
                    if (list.isNotEmpty()) {
                        _popularMovieList.postValue(list!!)
                    }
                }
                _loadingVisible.postValue(false)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}