package com.example.myapplication.data_model

import com.google.gson.annotations.SerializedName

class PredictorCategoryResponse(
    @SerializedName("attributes") val attributes: List<Any>,
    @SerializedName("category_id") val category_id: String,
    @SerializedName("category_name") val category_name: String,
    @SerializedName("domain_id") val domain_id: String,
    @SerializedName("domain_name")val domain_name: String
)