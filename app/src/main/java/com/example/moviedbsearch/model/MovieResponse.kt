package com.example.moviedbsearch.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    val results: List<Movies>
): Parcelable

@Parcelize
data class Movies(
    @Json(name = "original_title")
    val title: String?,
    val id: Int?,
    @Json(name = "poster_path")
    val posterPath: String?,
    val overview: String?
): Parcelable

