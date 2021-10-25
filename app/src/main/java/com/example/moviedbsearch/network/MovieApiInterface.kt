package com.example.moviedbsearch.network

import com.example.moviedbsearch.model.*
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApiInterface {

    //https://api.themoviedb.org/3/movie/popular?api_key=313450572cb8116b4ef05d894ea8fdbd&language=en-US&page=1

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String,
                                 @Query("language") language: String,
                                 @Query("page") page: Int): Deferred<Response<MovieResponse>>


    //https://api.themoviedb.org/3/search/multi?api_key=313450572cb8116b4ef05d894ea8fdbd&language=en-US&query=john&page=1&include_adult=false

    @GET("search/multi")
    fun getSearchResults(@Query("api_key") apiKey: String,
                         @Query("language") language: String,
                         @Query("query") query:String,
                         @Query("page") page: Int,
                         @Query("include_adult") includeAdult: Boolean): Deferred<Response<SearchResponse>>

    //https://api.themoviedb.org/3/movie/157336?api_key=313450572cb8116b4ef05d894ea8fdbd&append_to_response=videos
    @GET("movie/{id}")
    fun getMovieDetails(@Path("id") movieId: Int,
                        @Query("api_key") apiKey: String,
                        @Query("append_to_response") appendToResponse: String): Deferred<Response<MovieDetailResponse>>


    //https://api.themoviedb.org/3/movie/157336/credits?api_key=313450572cb8116b4ef05d894ea8fdbd&language=en-US&page=1
    @GET("movie/{id}/credits")
    fun getCast(@Path("id") movieId: Int,
                @Query("api_key") apiKey: String,
                @Query("language") language: String,
                @Query("page") page: Int): Deferred<Response<CastResponse>>


    //https://api.themoviedb.org/3/person/2524?api_key=313450572cb8116b4ef05d894ea8fdbd&language=en-US
    @GET("person/{id}")
    fun getPerson(@Path("id")personId: Int,
                @Query("api_key") apiKey: String,
                @Query("language") language: String): Deferred<Response<CastPerson>>


    //https://api.themoviedb.org/3/person/2524/movie_credits?api_key=313450572cb8116b4ef05d894ea8fdbd&language=en-US
    @GET("person/{id}/movie_credits")
    fun getMoviesOfPerson(@Path("id") personId: Int,
                @Query("api_key") apiKey: String,
                @Query("language") language: String) : Deferred<Response<MoviesPerson>>


    //https://api.themoviedb.org/3/person/2524/tv_credits?api_key=313450572cb8116b4ef05d894ea8fdbd&language=en-US
    @GET("person/{id}/tv_credits")
    fun getTvShowsOfPerson(@Path("id") personId: Int,
                          @Query("api_key") apiKey: String,
                          @Query("language") language: String) : Deferred<Response<TvShowsPerson>>



}