package com.example.JSON_Rest_API_products_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryActivity
import com.example.JSON_Rest_API_products_test.GalleryPage.MensImages

class WomensCategoryLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_womens_category_layout)

        val image = intent.getParcelableExtra<MensImages>(GalleryActivity.INTENT_PARCELABLE)


        //  ASSIGNING THE VARS
        val imgSrc = findViewById<ImageView>(R.id.womensCategoryImage)
        val imgTitle = findViewById<TextView>(R.id.womensCategoryTitle)
        val imgDescription = findViewById<TextView>(R.id.womensCategoryDescription)
        val imagePrice = findViewById<TextView>(R.id.womensCategoryPrice)
        val imageSize = findViewById<TextView>(R.id.womensCategorySize)

        // CALLING FROM MENS IMAGE CLASS
        if (image != null) {
            imgSrc.setImageResource(image.imageSource)
        }
        if (image != null) {
            imgTitle.text = image.imageTitle
        }
        if (image != null) {
            imgDescription.text = image.imageDescription
        }
        if (image!= null) {
            imagePrice.text = image.imagePrice
        }
        if (image!= null) {
            imageSize.text = image.imageSize
        }
    }
}