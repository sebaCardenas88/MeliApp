package com.example.myapplication.data_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
@Parcelize
data class Body(
    val condition: String,
    val currency_id: String,
    val pictures:List<Picture>,
    val price: Double,
    val title: String,
    val warranty: String?,
    val attributes:List<Atribute>):Parcelable

