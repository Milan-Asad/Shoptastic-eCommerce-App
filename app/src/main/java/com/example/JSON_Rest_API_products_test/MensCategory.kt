package com.example.JSON_Rest_API_products_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryActivity
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryAdapter
import com.example.JSON_Rest_API_products_test.GalleryPage.MensImageAdapter
import com.example.JSON_Rest_API_products_test.GalleryPage.MensImages
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.android.synthetic.main.activity_mens_category.*

class MensCategory : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MensCategoryAdapter.ViewHolder1>? = null

    lateinit var MyAdapter: MyAdapter
    lateinit var LinearLayoutManager: LinearLayoutManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mens_category)

        // LINK UP
        val image = intent.getParcelableExtra<MensImages>(GalleryActivity.INTENT_PARCELABLE)

        // BINDING TEXT
        val imgSrc = findViewById<ImageView>(R.id.mensCategoryImage)
        val imgTitle = findViewById<TextView>(R.id.mensCategoryTitle)
        val imgDescription = findViewById<TextView>(R.id.mensCategoryDescription)
        val imagePrice = findViewById<TextView>(R.id.mensCategoryPrice)
        val imageSize = findViewById<TextView>(R.id.mensCategorySize)

        // BINDING BUTTONS
        val buynowBtn = findViewById<Button>(R.id.buynowBtn)

        // MAKING IT NULL TO SHOW THE TEXT AND IMAGE
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

        // ONCLICK TO OPEN CHECKOUT PAGE
        buynowBtn.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            Intent.FLAG_ACTIVITY_NO_ANIMATION
            //Toast.makeText(applicationContext,"SERVICE NOT AVAILABLE RIGHT NOW", Toast.LENGTH_SHORT).show()
        }







        /*
        // RECYCLERVIEW ETC STUFF

        val menscategory_recyclerview = findViewById<RecyclerView>(R.id.menscategory_recyclerview)

        layoutManager = LinearLayoutManager(this)
        menscategory_recyclerview.layoutManager = layoutManager
        adapter = MensCategoryAdapter()
        menscategory_recyclerview.adapter = adapter

         */


    }
}