package com.example.moviedbsearch.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowsPerson(
    val cast: List<CastTv>
): Parcelable


@Parcelize
data class CastTv(
    val id: Int?,
    val name: String?,
    @Json(name = "poster_path")
    val posterPath: String?
    ): Parcelable



@Parcelize
data class MoviesPerson(
    val cast: List<CastMovie>
): Parcelable


@Parcelize
data class CastMovie(
    val id: Int?,
    val title: String?,
    @Json(name = "poster_path")
    val posterPath: String?
): Parcelable
