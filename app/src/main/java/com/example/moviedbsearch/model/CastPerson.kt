package com.example.moviedbsearch.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CastPerson(
    @Json(name = "known_for_department")
    val role: String?,
    val name: String?,
    val id: Int?,
    @Json(name = "profile_path")
    val profilePath: String?,
    val biography: String?,
): Parcelable