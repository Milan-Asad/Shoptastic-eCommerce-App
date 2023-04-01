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
        // REMEMBER ALL IMAGES ARE MEANT TO BE 956x1285
        val MensimageList = listOf<MensImages>(
            MensImages(
                R.raw.menssuit,
                "NAVY BLUE SUIT",
                "Every wardrobe needs a suit that offers versatility and value, a suit that will take you from work to weddings and everything in between. Tailored to precision and perfection, this suit will add a new dimension to your wardrobe, giving it depth, colour and taste. Order your luxurious navy blue suit today. (For tailored fitting sizes, please click here).",
                "Price: £149.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.menstshirt,
                "T-SHIRT",
                "A thin t-shirt, perfect for wearing in suffer. This t-shirt is made from 100% cotton to give a satisfying, comfortable feeling when wearing it. T-shirts offer versatility, from wearing it as an undershirt to being able to wear it on its own. Our t-shirts are available at a low cost, because everybody needs a t-shirt. Order yours today.",
                "Price: £2.50",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.mensjacketv1,
                "BROWN TRENCH COAT",
                "Inspired by british heritage, tailored to perfection and embraced with modernity. This brown trench coat can take your wardrobe to the unknown. Crafted by experienced tailors with years of experience to make it as premium as possible, this coat is exclusively available only on this site. Order your trench coat today.",
                "Price: £59.99",
                "Size: XS, S, M, L"
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