package com.example.myapplication.data_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Atribute(
    val attribute_group_id: String?,
    val attribute_group_name: String?,
    val id: String?,
    val name: String?,
    val value_id: String?,
    val value_name: String?
): Parcelable