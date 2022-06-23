package com.example.myapplication.api_service

import com.example.myapplication.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Here I have the instance of Retrofit, for avoiding repeting code
 * */
object RetrofitInstance {

    private val retrofit=Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api= retrofit.create(APIInterface::class.java)

}

