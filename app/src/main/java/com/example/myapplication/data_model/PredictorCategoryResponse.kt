package com.example.myapplication.data_model

import com.google.gson.annotations.SerializedName

class PredictorCategoryResponse(
    @SerializedName("category_id") val category_id: String,
    @SerializedName("domain_name")val domain_name: String
)
