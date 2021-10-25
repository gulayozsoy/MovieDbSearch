package com.example.moviedbsearch.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsearch.model.Cast
import com.example.moviedbsearch.model.MovieDetailResponse
import com.example.moviedbsearch.model.Video
import com.example.moviedbsearch.repository.MoviesRepository
import com.example.moviedbsearch.util.Constants.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(private val repository: MoviesRepository): ViewModel() {

    private val _movieData = MutableLiveData<MovieDetailResponse>()
    val movieData: LiveData<MovieDetailResponse> = _movieData

    private val _rating = MutableLiveData<Float>()
    val rating: LiveData<Float> = _rating

    private val _castList = MutableLiveData<List<Cast>>()
    val castList: LiveData<List<Cast>> = _castList

    private val _videoList = MutableLiveData<List<Video>>()
    val videoList: LiveData<List<Video>> = _videoList


    fun getData(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val movieItem = withContext(Dispatchers.IO) {
                    repository.getMovieDetails(movieId, API_KEY, "videos")
                }
                _movieData.postValue(movieItem!!)
                _videoList.postValue(movieItem.videos.results)
                _rating.postValue((movieItem.voteAverage)?.div(2) ?: 0.0f)

                val list = withContext(Dispatchers.IO) {
                    repository.getCast(movieId, API_KEY, "en-US", 1)
                }
                _castList.postValue(list!!)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}