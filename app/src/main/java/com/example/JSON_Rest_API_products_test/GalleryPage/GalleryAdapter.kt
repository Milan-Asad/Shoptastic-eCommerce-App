package com.example.JSON_Rest_API_products_test.GalleryPage

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.MainActivity
import com.example.JSON_Rest_API_products_test.R

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    // EXPERIMENTAL
    private var images = intArrayOf(
        // MENS
        R.raw.mensjacketnew,

        // WOMENS
        R.raw.femaleclothingcategory
    )
    private var text = arrayOf(
        "MEN",
        "WOMEN")




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.gallery_list_cardview, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gallerytxt.text = text[position]
        holder.galleryimages.setImageResource(images[position])
    }



    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var gallerytxt: TextView
        var galleryimages: ImageView

        init {
            gallerytxt = itemView.findViewById(R.id.gallerytxt)
            galleryimages = itemView.findViewById(R.id.galleryimage)



            itemView.setOnClickListener {
                val intent = Intent(itemView.context, MainActivity::class.java)

                itemView.context.startActivity(intent)
            }

        }
    }



}
