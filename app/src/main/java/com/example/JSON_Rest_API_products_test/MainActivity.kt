package com.example.JSON_Rest_API_products_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.Throwaway.ThrowawayDataItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://fakestoreapi.com"

class MainActivity : AppCompatActivity() {

    // MAKING THE VARS
    lateinit var MyAdapter: MyAdapter
    lateinit var LinearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        // **TO DO AFTER MAKING NOTES**
        val recyclerViewUsers = findViewById<RecyclerView>(R.id.recyclerViewUsers)
        recyclerViewUsers.setHasFixedSize(true)
        LinearLayoutManager = LinearLayoutManager(this)
        recyclerViewUsers.layoutManager = LinearLayoutManager

        // CALLING THE DATA FROM THE FUNCTION BELOW
        getMyData()

    }

    // MAKING THE FUNCTION TO GET DATA FOR RETROFIT
    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()  // Starts Retrofit Builder
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)                // Calling the URL which holds the JSON files
            .build()                          // Building it
            .create(ApiInterface::class.java) // Creating it from the API class we made as we did a get request there

        // MAKING VARIABLE TO GET THE RETROFIT DATA
        // Weirdly we can use val or var and the app will still work just fine
        val retrofitData = retrofitBuilder.getData()

        // RetrofitData because that's the name of the var
        // retrofitData.enqueue(object : Callback<List<MyData>?> {
        retrofitData.enqueue(object : Callback<List<ThrowawayDataItem>?> {
            override fun onResponse(
                call: Call<List<ThrowawayDataItem>?>,          // Calling the list from MyDataItem
                response: Response<List<ThrowawayDataItem>?>   // The response is (once again) MyDataItem
                // Because we want to display that
            ) {
                // Response stuff here and !! is used to null it
                val responseBody = response.body()!!
                MyAdapter = MyAdapter(baseContext, responseBody)
                MyAdapter.notifyDataSetChanged()                    // Notifys whats attached when the data has changed and should update in the view

                // Below is getting the recycler view and attaching the adapter to it
                // Remember the adapter has all the information

                //val recyclerViewUsers = findViewById<RecyclerView>(R.id.recyclerViewUsers)
                recyclerViewUsers.adapter = MyAdapter

            }


            // ON-FAILURE which shows an error like Error 404
            override fun onFailure(call: Call<List<ThrowawayDataItem>?>, t: Throwable) {
                // FAILURE STUFF HERE
                Log.d("MainActivity", "onFailure: " + t.message)
                Toast.makeText(applicationContext,"Error 404, Restart the app", Toast.LENGTH_LONG).show()


            }



        })
    }
}



























/*
// HIDES ACTION BAR
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        // SPLASH SCREEN
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)  // Making intent and changing to the screen we want after
            startActivity(intent)
            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.
 */