package com.example.moviedbsearch.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class MovieDetailResponse(
    @Json(name = "original_title")
    val title: String?,
    val id: Int?,
    @Json(name = "poster_path")
    val posterPath: String?,
    val overview: String?,
    @Json(name = "vote_average")
    val voteAverage: Float?,
    val videos: @RawValue VideoObj
): Parcelable

@Parcelize
data class VideoObj(
    val results: List<Video>
): Parcelable

@Parcelize
data class Video(
    var id: String,
    var key: String,
    var name: String,
    var site: String
): Parcelable
