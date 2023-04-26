package com.example.JSON_Rest_API_products_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager




class MainSplashScreen : AppCompatActivity() {

    // MAKING THE VARS
    lateinit var MyAdapter: MyAdapter
    lateinit var LinearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        // SPLASH SCREEN
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)  // Making intent and changing to the screen we want after
            startActivity(intent)
            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.

    }

}