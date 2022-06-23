package com.example.myapplication.data_model

import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("body") val body: Body
)