package com.example.myapplication.data_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture(
    val id: String,
    val max_size: String,
    val quality: String,
    val secure_url: String,
    val size: String,
    val url: String
): Parcelable