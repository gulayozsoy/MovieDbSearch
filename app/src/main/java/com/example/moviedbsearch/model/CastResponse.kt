package com.example.moviedbsearch.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CastResponse(
    val cast: List<Cast>
): Parcelable


@Parcelize
data class Cast(
    val id: Int?,
    val name: String?,
    @Json(name = "profile_path")
    val profilePath: String? ): Parcelable
