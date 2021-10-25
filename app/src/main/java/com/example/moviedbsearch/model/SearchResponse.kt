package com.example.moviedbsearch.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResponse(
    val results: List<SearchResult>
): Parcelable

@Parcelize
data class SearchResult(
    val title: String?,
    val id: Int?,
    @Json(name = "poster_path")
    val posterPath: String?,
    val overview: String?,
    @Json(name = "media_type")
    val mediaType: String?,
    @Json(name = "profile_path")
    val profilePath: String?,
    val name: String?
): Parcelable
