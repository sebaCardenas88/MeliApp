package com.example.myapplication.data_model

import com.google.gson.annotations.SerializedName

data class Top20Response(
    @SerializedName("content") val content: List<Content>,
    @SerializedName("query_data")val query_data: QueryData
)