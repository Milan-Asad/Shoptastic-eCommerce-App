package com.example.JSON_Rest_API_products_test

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.GalleryPage.GalleryAdapter

class MensCategoryAdapter : RecyclerView.Adapter<MensCategoryAdapter.ViewHolder1>() {

    private var images = intArrayOf(
        // MENS
        R.raw.mensjacketnew,
        R.raw.menssuit,
        R.raw.menstshirt,

        // WOMENS
        R.raw.femaleclothingcategory

    )
    private var text = arrayOf(
        "MEN'S JACKET",
        "MEN'S SUIT",
        "MEN'S TSHIRT",

        "WOMENS TOPS"

    )


    // MAKING A VIEWHOLDER
    inner class ViewHolder1(itemView: View): RecyclerView.ViewHolder(itemView) {
        var menscategorytxt: TextView
        var menscategoryimage: ImageView

        init {
            menscategorytxt = itemView.findViewById(R.id.menscategorytxt)
            menscategoryimage = itemView.findViewById(R.id.menscategoryimage)



        }
    }

    // IMPLEMENTED METHODS FOR CLASS
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        val v1 = LayoutInflater.from(parent.context).inflate(R.layout.mens_category_cardview, parent, false)
        return ViewHolder1(v1)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        holder.menscategorytxt.text = text[position]
        holder.menscategoryimage.setImageResource(images[position])
    }
}