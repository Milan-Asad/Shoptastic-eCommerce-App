package com.example.JSON_Rest_API_products_test.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryActivity
import com.example.JSON_Rest_API_products_test.MainActivity
import com.example.JSON_Rest_API_products_test.R
import kotlinx.android.synthetic.main.activity_forgotten_password.*
import kotlinx.android.synthetic.main.activity_login.*

class ForgottenPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotten_password)


        // VALIDATION FOR PASSWORD
        forgottenpasswordbtn.setOnClickListener {
            val password = forgottenpasswordtxtbox.text.toString()

            // IF STATEMENTS
            // IF EMAIL CONTAINS @ SIGN
            if (password.contains("@")) {
                Toast.makeText(applicationContext,"Reset link has been sent to your email", Toast.LENGTH_SHORT).show()
            }
            // IF ITS BLANK
            if (password.isEmpty()) {
                Toast.makeText(applicationContext,"field cannot be blank", Toast.LENGTH_SHORT).show()
            }
            else { // OTHERWISE....
                Toast.makeText(applicationContext,"Please enter a valid email", Toast.LENGTH_SHORT).show()
            }
        }


        //**********BOTTOM TOOLBAR**********

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
    }
}