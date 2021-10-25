package com.example.moviedbsearch.ui.cast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsearch.model.*
import com.example.moviedbsearch.repository.MoviesRepository
import com.example.moviedbsearch.util.Constants.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CastViewModel(private val repository: MoviesRepository): ViewModel() {

    private val _personData = MutableLiveData<CastPerson>()
    val personData: LiveData<CastPerson> = _personData

    private val _tvList = MutableLiveData<List<CastTv>>()
    val tvList: LiveData<List<CastTv>> = _tvList

    private val _movieList = MutableLiveData<List<CastMovie>>()
    val movieList: LiveData<List<CastMovie>> = _movieList

    fun getData(personId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val personItem = withContext(Dispatchers.IO) {
                    repository.getPerson(personId, API_KEY, "en-US")
                }
                _personData.postValue(personItem!!)

                val list1 = withContext(Dispatchers.IO) {
                    repository.getTvShowsPerson(personId, API_KEY, "en-US")
                }
                _tvList.postValue(list1!!)

                val list2 = withContext(Dispatchers.IO) {
                    repository.getMoviesPerson(personId, API_KEY, "en-US")
                }
                _movieList.postValue(list2!!)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}