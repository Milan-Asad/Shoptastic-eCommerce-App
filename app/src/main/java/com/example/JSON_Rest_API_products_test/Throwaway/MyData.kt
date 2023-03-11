package com.example.JSON_Rest_API_products_test.Throwaway

import com.example.JSON_Rest_API_products_test.Throwaway.Product

data class MyData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int,

    val thumbnail: String,
    val title: String,
    val description: String,
    // STUFF I ADDED
//    val images: List<String>,
//    val description: String,
//    val price: Int,
//    val rating: Double,
//    val stock: Int,
//    val thumbnail: String,
//    val title: String

)