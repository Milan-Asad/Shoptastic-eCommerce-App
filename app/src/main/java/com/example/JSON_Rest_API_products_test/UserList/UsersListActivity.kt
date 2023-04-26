package com.example.JSON_Rest_API_products_test.UserList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryActivity
import com.example.JSON_Rest_API_products_test.LoginPage.LoginActivity
import com.example.JSON_Rest_API_products_test.MainActivity
import com.example.JSON_Rest_API_products_test.R
import com.example.JSON_Rest_API_products_test.UserData.UserAdapter
import com.example.JSON_Rest_API_products_test.UserData.UserDataItem
import kotlinx.android.synthetic.main.activity_users_list_activity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL_USER = "https://fakestoreapi.com"

class UsersListActivity : AppCompatActivity() {

    // MAKING THE VARS
    lateinit var UserAdapter: UserAdapter
    lateinit var LinearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list_activity)

        // OPENS MAIN SCREEN (LEFT)
        val ListBtn = findViewById(R.id.ListImage) as ImageView
        ListBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            overridePendingTransition(0, 0)
            Intent.FLAG_ACTIVITY_NO_ANIMATION

        }

        // OPENS MIDDLE LOGIN PAGE (MIDDLE)
        val LoginBtn = findViewById(R.id.SecurityImage) as ImageView
        LoginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            overridePendingTransition(0, 0)
            Intent.FLAG_ACTIVITY_NO_ANIMATION

        }

        // OPENS GALLERY PAGE (RIGHT)
        val ImageBtn = findViewById(R.id.PhotoImage) as ImageView
        ImageBtn.setOnClickListener {
            val intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)

            overridePendingTransition(0, 0)
            Intent.FLAG_ACTIVITY_NO_ANIMATION
        }

        // MAKING RECYCLERVIEW LIST
        val recyclerViewUserList = findViewById<RecyclerView>(R.id.recyclerViewUserList)
        LinearLayoutManager = LinearLayoutManager(this)
        recyclerViewUserList.layoutManager = LinearLayoutManager

        GetUserListData()
    }

    private fun GetUserListData() {

        // **********COROUTINES**********
        val coroutineScope = CoroutineScope(Dispatchers.Main) // MAKE THE VARIABLE
        coroutineScope.launch {               // NOW ASSIGN VARIABLE TO FUNCTION
            delay(500L)                              // DELAYING IT BY 0.5 SECONDS

            // RETROFIT CALL AGAIN FOR ADMIN ACCESS
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL_USER)
                .build()
                .create(ApiUserInterface::class.java)

            val retrofitData = retrofitBuilder.GetUserListData()


            retrofitData.enqueue(object : Callback<List<UserDataItem>?> {
                override fun onResponse(
                    call: Call<List<UserDataItem>?>,
                    response: Response<List<UserDataItem>?>
                    // As we want to display that
                ) {
                    // Response stuff here and !! is used to null it
                    val responseBody = response.body()!!
                    UserAdapter = UserAdapter(baseContext, responseBody)
                    UserAdapter.notifyDataSetChanged()                    // Notifys whats attached when the data has changed and should update in the view

                    // Below is getting the recycler view and attaching the adapter to it



                    recyclerViewUserList.adapter = UserAdapter

                }


                // ON-FAILURE which shows an error like Error 404
                override fun onFailure(call: Call<List<UserDataItem>?>, t: Throwable) {
                    // FAILURE STUFF HERE
                    Log.d("MainActivity", "onFailure: " + t.message)
                    Toast.makeText(
                        applicationContext,
                        "Error 404, Refresh or restart the app",
                        Toast.LENGTH_LONG
                    ).show()


                }


            })
        }
    }
}