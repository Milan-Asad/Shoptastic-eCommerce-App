package com.example.JSON_Rest_API_products_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryActivity
import com.example.JSON_Rest_API_products_test.LoginPage.LoginActivity
import com.example.JSON_Rest_API_products_test.UserData.UserAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

class MeetTheTeam : AppCompatActivity() {


    // MAKING THE VARS
    lateinit var MTTAdapter: MeetTheTeamAdapter
    lateinit var LinearLayoutManager: LinearLayoutManager


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_meet_the_team)



            // MAKING RECYCLERVIEW LIST
            val MTTRecyclerView = findViewById<RecyclerView>(R.id.meetTheTeam_RecyclerView)
            LinearLayoutManager = LinearLayoutManager(this)
            MTTRecyclerView.layoutManager = LinearLayoutManager
            MTTRecyclerView.adapter = MeetTheTeamAdapter()


            //*****TOP TOOLBAR*****

            // TOOLBAR OPENS ABOUT US PAGE
            val ToolbarBtn = findViewById(R.id.ShoptasticTxt) as TextView
            ToolbarBtn.setOnClickListener {
                val intent = Intent(this, AboutUs::class.java)
                startActivity(intent)

                overridePendingTransition(0, 0)
                Intent.FLAG_ACTIVITY_NO_ANIMATION
            }

            // OPENS MAIN SCREEN (LEFT)
            val ListBtn = findViewById(R.id.ListImage) as ImageView
            ListBtn.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                overridePendingTransition(0, 0)
                Intent.FLAG_ACTIVITY_NO_ANIMATION

            }

            //*****BOTTOM TOOLBAR*****

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

        }
    }
