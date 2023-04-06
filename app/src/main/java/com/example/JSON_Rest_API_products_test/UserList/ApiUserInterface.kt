package com.example.JSON_Rest_API_products_test.UserList

import com.example.JSON_Rest_API_products_test.Throwaway.ThrowawayDataItem
import com.example.JSON_Rest_API_products_test.UserData.UserDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiUserInterface {

    @GET("users")
    // FUNCTION TO CALL DURING RETROFIT
    fun GetUserListData(): Call<List<UserDataItem>>
}