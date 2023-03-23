package com.example.JSON_Rest_API_products_test.GalleryPage

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.LoginPage.LoginActivity
import com.example.JSON_Rest_API_products_test.MainActivity
import com.example.JSON_Rest_API_products_test.MensCategory
import com.example.JSON_Rest_API_products_test.R
import com.example.JSON_Rest_API_products_test.WomensCategory
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity() {

    // COMPANION OBJECT
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<GalleryAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        // MAKKING ARRAY FOR MENS IMAGE PAGE
        val MensimageList = listOf<MensImages>(
            MensImages(
                R.raw.menssuit,
                "MALE CLOTHING",
            ),
            MensImages(
                R.raw.femaleclothingcategory,
                "FEMALE CLOTHING",
            )

        )


        // RECYCLERVIEW ETC STUFF
        layoutManager = LinearLayoutManager(this)
        gallery_recyclerview.layoutManager = layoutManager
        adapter = GalleryAdapter()
        gallery_recyclerview.adapter = MensImageAdapter(this, MensimageList) {
            val intent = Intent(this, MensCategory::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        /*
        recyclerView.adapter = ImageAdapter(this, imageList){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
         */

        //********** TOP NAVIGATION BAR **********
        val womensBtn = findViewById<Button>(R.id.womensBtn)
        womensBtn.setOnClickListener {
            val intent = Intent(this, WomensCategory::class.java)
            startActivity(intent)

            overridePendingTransition(0, 0)
            Intent.FLAG_ACTIVITY_NO_ANIMATION
        }


        //********** BOTTOM NAVIGATION BAR **********

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

/*
layoutManager = LinearLayoutManager(this)
        gallery_recyclerview.layoutManager = layoutManager
        adapter = GalleryAdapter()
        gallery_recyclerview.adapter = adapter

 */