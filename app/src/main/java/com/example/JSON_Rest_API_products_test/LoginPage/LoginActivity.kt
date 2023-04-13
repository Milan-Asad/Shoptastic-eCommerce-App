package com.example.JSON_Rest_API_products_test.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.JSON_Rest_API_products_test.CheckoutActivity
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryActivity
import com.example.JSON_Rest_API_products_test.MainActivity
import com.example.JSON_Rest_API_products_test.R
import com.example.JSON_Rest_API_products_test.UserList.UsersListActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // MAKING VARIABLE FOR THE EDIT TEXT AND LOGIN BUTTON
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        // CALLING IT TO A STRING TO CHECK IF THE TEXT MATCHES THE IF STATEMENTS
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // ***IF STATEMENTS***
            if (username == "admin" && password == "password") {        // ADMIN ACCESS (TO SHOW THE USERLIST DISPLAY)
                val intent = Intent(this, UsersListActivity::class.java)
                startActivity(intent)
                finish()
            } else if (username == "milan" && password == "password") { // TO LOG INTO CHECKOUT ACCOUNT
                val intent = Intent(this, CheckoutActivity::class.java)
                startActivity(intent)
                finish()
            } else {                                                    // DISPLAYS A INVALID TOAST
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()

            }

        }


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

        // FORGOTTEN PASSWORD TEXT CLICK
        val forgottenpasswordtxt = findViewById<TextView>(R.id.forgottenpasswordtxt)
        forgottenpasswordtxt.setOnClickListener {
            //Toast.makeText(applicationContext,"Service not available right now", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, ForgottenPasswordActivity::class.java)
            startActivity(intent)

            overridePendingTransition(0, 0)
            Intent.FLAG_ACTIVITY_NO_ANIMATION
        }
    }
}