package com.example.JSON_Rest_API_products_test

import com.example.JSON_Rest_API_products_test.Throwaway.ThrowawayDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products") // PERFORMING A GET REQUEST
    fun getData(): Call<List<ThrowawayDataItem>> // MAKING A FUNCTION TO ATTACH TO RETROFIT
    // THIS FUNCTION IS MAKING A CALL TO THE SERVER TO SEND THE DATA

}