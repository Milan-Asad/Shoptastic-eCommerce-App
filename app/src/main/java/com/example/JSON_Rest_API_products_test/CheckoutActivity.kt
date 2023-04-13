package com.example.JSON_Rest_API_products_test

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryActivity
import com.example.JSON_Rest_API_products_test.LoginPage.LoginActivity
import com.example.JSON_Rest_API_products_test.databinding.ActivityCheckoutBinding
import com.example.JSON_Rest_API_products_test.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_checkout)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // MAKING FUNCTION SIMILAR TO GET MY DATA IN RETROFIT
        emailListener()
        nameListener()
        cardnumberListener()
        CcvListener()
        ExpiryDateListener()

        //********** BOTTOM NAVIGATION STUFF **********
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


        // FOR THE PROGRESS STUFF
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val button = findViewById<Button>(R.id.checkoutBtn)

        button.setOnClickListener {
            if(emailEditText.text.isNullOrEmpty() || fullnameEditText.text.isNullOrEmpty() || cardNumberEditText.text.isNullOrEmpty() || expiryDateEditText.text.isNullOrEmpty() || CCVEditText.text.isNullOrEmpty()) {
                Toast.makeText(this, "Some fields are incompleted", Toast.LENGTH_SHORT).show()
            } else {


                progressBar.visibility = View.VISIBLE

                Handler(Looper.getMainLooper()).postDelayed({

                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(
                        applicationContext,
                        "Error: Could not connect to services",
                        Toast.LENGTH_SHORT
                    ).show()

                }, 3000)

            }

        }
    }






    // ********** VIEW BINDING STUFF **********

    // *******EMAIL STUFF*******
    private fun emailListener() {
        binding.emailEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String?
    {
        val emailText = binding.emailEditText.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Invalid Email Address"
        }
        return null
    }

    // ******NAME STUFF******
    private fun nameListener() {

        binding.fullnameEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.fullnameContainer.helperText = validName()
            }
        }

    }

    private fun validName(): String? {
        val nameText = binding.fullnameEditText.text.toString()
        if(nameText.isEmpty())
        {
            return "Enter your name"
        }
        return null
    }

    // *****CARD NUMBER STUFF*****
    private fun cardnumberListener() {
        binding.cardNumberEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.cardNumberContainer.helperText = validCardNumber()
            }
        }
    }

    private fun validCardNumber(): String? {
        val cardText = binding.cardNumberEditText.text.toString()
        if(cardText.isEmpty())
        {
            return "Enter your card number"
        }
        if(!cardText.matches(".*[0-9].*".toRegex()))
        {
            return "Digits only"
        }
        if(cardText.length < 16)
        {
            return "Must be 16 Digits"
        }
        return null
    }

    //****EXPIRY DATE STUFF****
    private fun ExpiryDateListener() {
        binding.expiryDateEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.expiryDateContainer.helperText = validExpiryDate()
            }
        }
    }

    private fun validExpiryDate(): String? {
        val ExpiryDate = binding.expiryDateEditText.text.toString()
        if(ExpiryDate.isEmpty())
        {
            return "Enter your expiry date"
        }
        if(ExpiryDate.length < 5)
        {
            return "Must be 5 Digits with a / in the middle"
        }
        if(!ExpiryDate.contains("/"))
        {
            return "Must contain a / in the middle"

        }
        return null
    }

    //****CCV STUFF****
    private fun CcvListener() {
        binding.CCVEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.CCVContainer.helperText = validCCV()
            }
        }
    }

    private fun validCCV(): String? {
        val CCVTxt = binding.CCVEditText.text.toString()
        if(CCVTxt.isEmpty())
        {
            return "Enter your CCV number"
        }
        if(CCVTxt.length < 3)
        {
            return "Must be 3 Digits"
        }
        return null
    }


}

/*
STUFF NEEDED FOR PAYMENT PAGE:

EMAIL (done)
FULL NAME (done)
POSTCODE?
CARD NUMBER
EXPIRATION DATE
CCV

PAY NOW BUTTON

*/

