package com.example.JSON_Rest_API_products_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
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
                "WHITE TURTLENECK",
                "100% cotten. Our turtlenecks provide you with comfort that can last the whole day. Designed with multi-layer stitching to prevent heat loss in the winter. Add this turtleneck to your wardrobe today. Specifically designed for women.",
                "Price: £9.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womenssuit1,
                "BLACK SUIT",
                "Slim-fitted and tailored to precision. We have launched our new suit for women. With 2 inside and outside pockets, we can assure you this suit will not leave you short on space. Slim fitted, lightweight and luxurious. Perfect for wearing to a formal occasion and to the office. Order your suit today (only exclusively sold here).",
                "Price: £149.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womensblackformaltrousers,
                "BLACK TROUSERS",
                "Regular, standard black trousers. Perfectly accompanied whether you wear a blazer or a shirt with it. Our black trousers have smooth cotton padding inside, to give you a mesmerising comfort when spending hours sitting down. Order your trousers today.",
                "Price: £16.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womensformaltrousers,
                "GREY TROUSERS",
                "Vintage fashioned brown formal trousers. Perfectly accompanied whether you wear a blazer or a shirt with it. Our vintage brown trousers have smooth cotton padding inside, to give you a mesmerising comfort when spending hours sitting down. Specifically tailored with love by our experts. Order your trousers today.",
                "Price: £19.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womensdenimjacket1,
                "RIVA DENIM JACKET",
                "Every wardrobe needs a suit that offers versatility and value, a suit that will take you from work to weddings and everything in between. Tailored to precision and perfection, this suit will add a new dimension to your wardrobe, giving it depth, colour and taste. Order your luxurious navy blue suit today. (For tailored fitting sizes, please click here).",
                "Price: £24.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womensvnecktshirt,
                "SHORT SLEEVE V-NECK",
                "Every wardrobe needs a suit that offers versatility and value, a suit that will take you from work to weddings and everything in between. Tailored to precision and perfection, this suit will add a new dimension to your wardrobe, giving it depth, colour and taste. Order your luxurious navy blue suit today. (For tailored fitting sizes, please click here).",
                "Price: £24.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womensshirt,
                "SATIN SHIRT",
                "A simple, smooth, soft shirt with a punchy shine. Greats for wearing at parties or as a casual fit. All our satin shirts undertake a stress test, so it can last longer to keep your smile going. Order your satin shirt today.",
                "Price: £13.99",
                "Size: XS, S, M, L, XL, XL"
            ),
            MensImages(
                R.raw.womenstshirt,
                "COTTON  T-SHIRT",
                "A soft and simple t-shirt. Every wardrobe needs a t-shirt. The most versatile clothing wear, perfect for all seasons. Made with 100% cotton to provide a comforting experience. Order your t-shirt today.",
                "Price: £2.50",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womensblackjeans,
                "BLACK SLIM JEANS",
                "Jeans have become more and popular in this decade, due to it's ability to be worn at almost any occasion. The standard go to trousers when heading out. Our jeans are designed to withhold strain and abuse back in our tailoring factory. Order your jeans today.",
                "Price: £14.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womensgreyjeans,
                "GREY SLIM JEANS",
                "Jeans have become more and popular in this decade, due to it's ability to be worn at almost any occasion. The standard go to trousers when heading out. Our jeans are designed to withhold strain and abuse back in our tailoring factory. Order your jeans today.",
                "Price: £14.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womensjeans,
                "SLIM-FIT JEANS",
                "Jeans have become more and popular in this decade, due to it's ability to be worn at almost any occasion. The standard go to trousers when heading out. Our jeans are designed to withhold strain and abuse back in our tailoring factory. Order your jeans today.",
                "Price: £14.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.womensankleboots,
                "SUEDE ANKLE BOOTS",
                "A soft and simple t-shirt. Every wardrobe needs a t-shirt. The most versatile clothing wear, perfect for all seasons. Made with 100% cotton to provide a comforting experience. Order your t-shirt today.",
                "Price: £32.99",
                "Size: 2, 3, 4, 5, 6, 7, 8"
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

        val launchingSoonBtn1 = findViewById<Button>(R.id.launchingSoonWomens1Btn)
        launchingSoonBtn1.setOnClickListener {
            Toast.makeText(this, "Launching soon", Toast.LENGTH_SHORT).show()
        }

        val launchingSoonBtn2 = findViewById<Button>(R.id.launchingsoonwomens2Btn)
        launchingSoonBtn2.setOnClickListener {
            Toast.makeText(this, "Launching soon", Toast.LENGTH_SHORT).show()
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