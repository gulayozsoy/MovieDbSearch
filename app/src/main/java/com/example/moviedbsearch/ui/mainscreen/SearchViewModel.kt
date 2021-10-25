package com.example.moviedbsearch.ui.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsearch.model.SearchResult
import com.example.moviedbsearch.repository.MoviesRepository
import com.example.moviedbsearch.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: MoviesRepository): ViewModel() {

    private val _movieListSearch = MutableLiveData<List<SearchResult>>()
    val movieListSearch: LiveData<List<SearchResult>> = _movieListSearch

    private val _tvListSearch = MutableLiveData<List<SearchResult>>()
    val tvListSearch: LiveData<List<SearchResult>> = _tvListSearch

    private val _personListSearch = MutableLiveData<List<SearchResult>>()
    val personListSearch: LiveData<List<SearchResult>> = _personListSearch


    private val _loadingVisible = MutableLiveData(false)
    val loadingVisible: LiveData<Boolean> get() = _loadingVisible

    fun getQuery(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingVisible.postValue(true)
            try {
                val list = repository.getSearchResults(Constants.API_KEY, "en-US", query, 4, false)
                if (list != null) {
                    if (list.isNotEmpty()) {
                        _movieListSearch.postValue(list.filter { it.mediaType == "movie" })
                        _tvListSearch.postValue(list.filter { it.mediaType == "tv" })
                        _personListSearch.postValue(list.filter { it.mediaType == "person" })
                    }
                }
                _loadingVisible.postValue(false)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}