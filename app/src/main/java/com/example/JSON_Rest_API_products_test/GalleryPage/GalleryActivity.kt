package com.example.JSON_Rest_API_products_test.GalleryPage

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
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
                "Every wardrobe needs a suit that offers versatility and value, a suit that will take you from work to weddings and everything in between. Tailored to precision and perfection, this suit will add a new dimension to your wardrobe, giving it depth, colour and taste. Order your luxurious navy blue suit today.",
                "Price: £149.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.menstshirt,
                "T-SHIRT",
                "A thin t-shirt, perfect for wearing in summer. This t-shirt is made from 100% cotton to give a satisfying, comfortable feeling when wearing it. T-shirts offer versatility, from wearing it as an undershirt to being able to wear it on its own. Our t-shirts are available at a low cost, because everybody needs a t-shirt in their wardrobe. Order yours today.",
                "Price: £2.50",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.mensjacketv1,
                "BROWN TRENCH COAT",
                "Inspired by british heritage, tailored to perfection and embraced with modernity. This brown trench coat can take your wardrobe to the unknown. Crafted by experienced tailors with years of experience to make it as premium as possible, this coat is exclusively available only on this site. Order your trench coat today.",
                "Price: £59.99",
                "Size: XS, S, M, L"
            ),
            MensImages(
                R.raw.mensredtrenchcoat,
                "RED TRENCH COAT",
                "Inspired by british heritage, tailored to perfection and embraced with its vividness. This red trench coat can take your wardrobe to the unknown. Crafted by experienced tailors with years of experience to make it as premium as possible, this coat is exclusively available only on this site. Order your trench coat today. ",
                "Price: £99.99",
                "Size: XS, S, M, L, XL"
            ),
            MensImages(
                R.raw.mensdenimjacket,
                "WORKS DENIM JACKET",
                "Denim jackets are brilliant for sunshine weather. This jacket offers you versatility for your summer fits. Highly recommended with white jeans. Order your denim jacket today.",
                "Price: £29.99",
                "Size: XXS, XS, S, M, L, XL"
            ),
            MensImages(
                R.raw.mensshirt,
                "L&X SHIRT",
                "A bright, classy shirt. Matches perfectly with jeans. L&X Luxurious shirt range are specially designed to avoid creasing when standing. Order your shirt today.",
                "Price: £17.99",
                "Size: XXS, XS, S, M, L, XL"
            ),
            MensImages(
                R.raw.menspolo,
                "EAGLE  POLO",
                "A classic polo which adds flavour, depth and energy to your wardrobe. Highly recommended for sunny weather when on holiday, this polo is designed to keep you cool when the temperature turns up. Order your polo today.",
                "Price: £4.99",
                "Size: XS, S, M, L, XL"
            ),
            MensImages(
                R.raw.mensstripedpolo,
                "TRIFLE  POLO",
                "A triple striped polo. Stylish, sublime and stunning. Made with the finest material available, all to be sold at an affordable price. Add this to your wardrobe today.",
                "Price: £4.99",
                "Size: XS, S, M, L, XL"
            ),
            MensImages(
                R.raw.mensstripedtshirt,
                "TRIFLE  T-SHIRT",
                "A triple striped t-shirt, Stylish and stunning, available at an affordable price. Made with the finest material available, all to be sold at an affordable price. Order your t-shirt today.",
                "Price: £3.99",
                "Size: XXS, XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.mensfloralshirt,
                "FLORAL  SHIRT",
                "A floral-printed design on a thin shirt, what more could you ask for going on holiday? Thin and breathable, this shirt is perfect for going to warm weather countries. Order your floral shirt today.",
                "Price: £17.99",
                "Size: XXS, XS, S, M, L, XL"
            ),
            MensImages(
                R.raw.mensbluehoodie,
                "1890  HOODIE",
                "A sky-blue hoodie with a gradient fade, padded with soft cotton inside to give you a smooth feeling. Designed to be slim-fitted. Order your Hoodie today.",
                "Price: £19.99",
                "Size: XS, S, M, L, XL, XXL"
            ),
            MensImages(
                R.raw.menspurplevneck,
                "PREMIER  V-NECK",
                "A rich-purple V-neck made with fine cotton, precisely threaded to give your body an amazing feeling. V-necks work perfectly over a shirt. Order your V-Neck today.",
                "Price: £19.99",
                "Size: XS, S, M, L, XL"
            ),
            MensImages(
                R.raw.mensknitwear,
                "VINTAGE  KNITWEAR",
                "Knitted by experts, this vintage knitwear is perfect for winter. Using extra thick wool to keep you warm when the temperature falls. Can be worn alone or over a shirt. Order your Knitwear today.",
                "Price: £24.99",
                "Size: XS, S, M, L, XL"
            ),



        )

        // WRITING A LOG MESSAGE
        Log.d("Response", "Mens Category count response is: ${MensimageList.size}")

        // RECYCLERVIEW ETC STUFF
        layoutManager = LinearLayoutManager(this)
        gallery_recyclerview.layoutManager = layoutManager
        adapter = GalleryAdapter()
        gallery_recyclerview.adapter = MensImageAdapter(this, MensimageList) {
            val intent = Intent(this, MensCategory::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }



        //********** TOP NAVIGATION BAR **********
        val womensBtn = findViewById<Button>(R.id.womensBtn)
        womensBtn.setOnClickListener {
            val intent = Intent(this, WomensCategory::class.java)
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
