package com.example.JSON_Rest_API_products_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryActivity
import kotlinx.android.synthetic.main.activity_gallery.*

class WomensCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_womens_category)


        //********** TOP NAVIGATION BAR **********
        val mensBtn = findViewById<Button>(R.id.mensBtn)
        mensBtn.setOnClickListener {
            val intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)

            overridePendingTransition(0, 0)
            Intent.FLAG_ACTIVITY_NO_ANIMATION
        }

    }
}