package com.example.JSON_Rest_API_products_test.GalleryPage

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MensImages(
    val imageSource : Int,
    val imageTitle: String,
    val imageDescription: String,
    val imagePrice: String,
    val imageSize: String,
): Parcelable
