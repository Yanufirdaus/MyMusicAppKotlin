package com.example.mysimpleandroidproject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Music(
    var titles: String,
    var artist: String,
    var releaseyear: String,
    var photo: String,
    var links: String,
    var lyrics: String,
    var linkspotify: String,
    var viewsamount : String
): Parcelable
