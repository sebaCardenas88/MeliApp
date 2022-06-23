package com.example.myapplication.api_service

import com.example.myapplication.constants.Constants
import com.example.myapplication.constants.Constants.Companion.ACCESS_TOKEN
import com.example.myapplication.data_model.ItemResponse
import com.example.myapplication.data_model.PredictorCategoryResponse
import com.example.myapplication.data_model.Top20Response
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * In this interface, i have the differents calls to the API that will be used for the differents searchings
 * */
interface APIInterface {


            @GET("sites/MLA/domain_discovery/search?limit=1")
            suspend fun getCategoryPredictor(@Query("q") query:String):Response<List<PredictorCategoryResponse>>


            @Headers("Authorization: Bearer $ACCESS_TOKEN")
            @GET("highlights/MLA/category/{categories}")
            suspend fun getTwentyproducts(@Path("categories") categories:String):Response<Top20Response>


            @Headers("Authorization: Bearer $ACCESS_TOKEN")
            @GET("items")
            suspend fun getItems(@Query("ids")ids:String):Response<List<ItemResponse>>





}
