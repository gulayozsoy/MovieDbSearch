package com.example.moviedbsearch.repository

import com.example.moviedbsearch.model.*
import com.example.moviedbsearch.network.BaseRepository
import com.example.moviedbsearch.network.MoviesApiInterface


interface MoviesRepository {

    suspend fun getPopularMovies(apiKey: String, language: String, page: Int): List<Movies>?
    suspend fun getSearchResults(apiKey: String, language: String, query: String,
                                 page: Int, includeAdult: Boolean): List<SearchResult>?
    suspend fun getMovieDetails(movieId: Int, apiKey: String, appendToResponse: String ): MovieDetailResponse?
    suspend fun getCast(movieId: Int,apiKey: String, language: String, page: Int ): List<Cast>?
    suspend fun getPerson(personId: Int, apiKey: String, language: String): CastPerson?
    suspend fun getMoviesPerson(personId: Int, apiKey: String, language: String): List<CastMovie>?
    suspend fun getTvShowsPerson(personId: Int, apiKey: String, language: String): List<CastTv>?
}

class MoviesRepositoryImpl(private val apiService: MoviesApiInterface) : BaseRepository(), MoviesRepository {

    override suspend fun getPopularMovies(apiKey: String, language: String, page: Int): List<Movies>? {
        val movieResponse = safeApiCall(
            call = {apiService.getPopularMovies(apiKey, language, page).await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        return movieResponse?.results
    }

    override suspend fun getSearchResults(apiKey: String, language: String, query: String,
        page: Int, includeAdult: Boolean): List<SearchResult>? {

        val searchResponse = safeApiCall(
            call = {apiService.getSearchResults(apiKey, language, query, page, includeAdult).await()},
            errorMessage = "Error Fetching Popular Movies"
        )
        return searchResponse?.results
    }

    override suspend fun getMovieDetails(movieId: Int, apiKey: String,
                                         appendToResponse: String): MovieDetailResponse? {

        val detailResponse = safeApiCall(
            call = {apiService.getMovieDetails(movieId, apiKey, appendToResponse).await()},
            errorMessage = "Error Fetching Popular Movies"
        )
        return detailResponse
    }

    override suspend fun getCast(movieId: Int, apiKey: String, language: String,
                                 page: Int ): List<Cast>? {
        val castResponse = safeApiCall(
            call = {apiService.getCast(movieId, apiKey, language, page).await()},
            errorMessage = "Error Fetching Popular Movies"
        )
        return castResponse?.cast
    }

    override suspend fun getPerson(personId: Int, apiKey: String, language: String): CastPerson? {
        val personResponse = safeApiCall(
            call = {apiService.getPerson(personId, apiKey, language).await()},
            errorMessage = "Error Fetching Popular Movies"
        )
        return personResponse
    }

    override suspend fun getMoviesPerson(personId: Int, apiKey: String, language: String)
                    : List<CastMovie>? {
        val moviesPersonResponse = safeApiCall(
            call = {apiService.getMoviesOfPerson(personId, apiKey, language).await()},
            errorMessage = "Error Fetching Popular Movies"
        )
        return moviesPersonResponse?.cast
    }

    override suspend fun getTvShowsPerson( personId: Int, apiKey: String, language: String)
                    : List<CastTv>? {
        val tvPersonResponse = safeApiCall(
            call = {apiService.getTvShowsOfPerson(personId, apiKey, language).await()},
            errorMessage = "Error Fetching Popular Movies"
        )
        return tvPersonResponse?.cast
    }


}