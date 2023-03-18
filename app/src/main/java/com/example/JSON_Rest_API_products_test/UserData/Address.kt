package com.example.JSON_Rest_API_products_test.UserData

data class Address(
    val city: String,
    val geolocation: Geolocation,
    val number: Int,
    val street: String,
    val zipcode: String
)