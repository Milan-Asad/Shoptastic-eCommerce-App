package com.example.JSON_Rest_API_products_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
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

        /*
        val imgSrc = findViewById<ImageView>(R.id.menscategoryimage)
        val imgTitle = findViewById<TextView>(R.id.menscategorytxt)


        imgSrc.setImageResource(image.imageSource)
        imgTitle.text = image.imageTitle

         */

        // RECYCLERVIEW ETC STUFF
        val menscategory_recyclerview = findViewById<RecyclerView>(R.id.menscategory_recyclerview)

        layoutManager = LinearLayoutManager(this)
        menscategory_recyclerview.layoutManager = layoutManager
        adapter = MensCategoryAdapter()
        menscategory_recyclerview.adapter = adapter
    }
}