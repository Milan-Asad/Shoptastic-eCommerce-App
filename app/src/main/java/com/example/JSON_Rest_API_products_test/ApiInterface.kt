package com.example.JSON_Rest_API_products_test

import com.example.JSON_Rest_API_products_test.Throwaway.ThrowawayDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    fun getData(): Call<List<ThrowawayDataItem>>

}