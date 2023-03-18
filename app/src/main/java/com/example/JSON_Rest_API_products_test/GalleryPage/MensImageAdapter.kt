package com.example.JSON_Rest_API_products_test.GalleryPage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.R

class MensImageAdapter(
    private val context: Context,
    private val images: List<MensImages>,
    val listener: (MensImages) -> Unit
) : RecyclerView.Adapter<MensImageAdapter.MensImageViewHolder>() {


    // MAKING A VIEWHOLDER
    class MensImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // CALLING IT FROM MENS ITEM LIST XML
        val imageSrc = view.findViewById<ImageView>(R.id.menspageimage) // menspageimage
        val title = view.findViewById<TextView>(R.id.menspagetext)      // menspagetext

        // BINDING THE STUFF FROM MENS IMAGE
        fun bindView(image: MensImages, listener: (MensImages) -> Unit) {
            imageSrc.setImageResource(image.imageSource)
            title.text = image.imageTitle
            itemView.setOnClickListener { listener(image) }
        }

    }

    // IMPLEMENTING METHOD
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensImageViewHolder =
        MensImageViewHolder(LayoutInflater.from(context).inflate(R.layout.mens_item_list, parent, false)
        )

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: MensImageViewHolder, position: Int) {
        holder.bindView(images[position], listener)
    }
}