package com.example.JSON_Rest_API_products_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryActivity
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryAdapter
import com.example.JSON_Rest_API_products_test.GalleryPage.MensImageAdapter
import com.example.JSON_Rest_API_products_test.GalleryPage.MensImages
import com.example.JSON_Rest_API_products_test.LoginPage.LoginActivity
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.android.synthetic.main.activity_womens_category.*

class WomensCategory : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE_1 = "OBJECT_INTENT"
    }

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<GalleryAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_womens_category)

        // MAKKING ARRAY FOR WOMENS IMAGE PAGE
        // REMEMBER ALL IMAGES ARE MEANT TO BE 956x1285
        val WomensimageList = listOf<MensImages>(
            MensImages(
                R.raw.femaleclothingcategory,
                "WHITE TOP",
                "Every wardrobe needs a suit that offers versatility and value, a suit that will take you from work to weddings and everything in between. Tailored to precision and perfection, this suit will add a new dimension to your wardrobe, giving it depth, colour and taste. Order your luxurious navy blue suit today. (For tailored fitting sizes, please click here).",
                "Price: £49.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womenssuit1,
                "BLACK SUIT",
                "Every wardrobe needs a suit that offers versatility and value, a suit that will take you from work to weddings and everything in between. Tailored to precision and perfection, this suit will add a new dimension to your wardrobe, giving it depth, colour and taste. Order your luxurious navy blue suit today. (For tailored fitting sizes, please click here).",
                "Price: £429.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womensdenimjacket,
                "BLUE DENIM JACKET",
                "Every wardrobe needs a suit that offers versatility and value, a suit that will take you from work to weddings and everything in between. Tailored to precision and perfection, this suit will add a new dimension to your wardrobe, giving it depth, colour and taste. Order your luxurious navy blue suit today. (For tailored fitting sizes, please click here).",
                "Price: £429.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),







        )

        // RECYCLERVIEW ETC STUFF
        layoutManager = LinearLayoutManager(this)
        womenscategory_recyclerview.layoutManager = layoutManager
        adapter = GalleryAdapter()
        womenscategory_recyclerview.adapter = MensImageAdapter(this, WomensimageList) {
            val intent = Intent(this, MensCategory::class.java)
            intent.putExtra(GalleryActivity.INTENT_PARCELABLE, it)
            startActivity(intent)
        }


        //********** TOP NAVIGATION BAR **********
        val mensBtn = findViewById<Button>(R.id.mensBtn)
        mensBtn.setOnClickListener {
            val intent = Intent(this, GalleryActivity::class.java)
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