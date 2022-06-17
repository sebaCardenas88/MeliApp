package com.example.myapplication.data_model

import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("id") val id: String,
    @SerializedName("position") val position: Int,
    @SerializedName("type") val type: String
)