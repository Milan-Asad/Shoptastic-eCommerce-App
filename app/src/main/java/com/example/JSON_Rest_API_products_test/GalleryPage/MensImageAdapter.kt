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
    private val context: Context, // MEANS ENVIRONMENT
    private val images: List<MensImages>, // DATA CLASS FOR LATER
    val listener: (MensImages) -> Unit // DATA-CLASS (ASSIGN DATA) TO ASSIGN TEXT AND IMAGE WHEN CLICKED
) : RecyclerView.Adapter<MensImageAdapter.MensImageViewHolder>() { // RECYCLERVIEW W/ADAPTER


    // MAKING A VIEWHOLDER
    class MensImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // CALLING IT FROM MENS-ITEM-LIST XML
        val imageSrc = view.findViewById<ImageView>(R.id.menspageimage)
        val title = view.findViewById<TextView>(R.id.menspagetext)

        // BINDING THE STUFF FROM MENS IMAGE
        fun bindView(image: MensImages, listener: (MensImages) -> Unit) {
            // BINDING TO MENS-IMAGE DATA CLASS
            imageSrc.setImageResource(image.imageSource)
            title.text = image.imageTitle

            // THE IMAGE IS THE LISTENER
            itemView.setOnClickListener { listener(image) }
        }


    }

    // IMPLEMENTING METHOD
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensImageViewHolder =
        MensImageViewHolder(LayoutInflater.from(context).inflate(R.layout.mens_item_list, parent, false)
        )

    // RETURN THE AMOUNT OF IMAGES
    override fun getItemCount(): Int = images.size

    // BINDING IMAGES TO POSITION + LISTENER
    override fun onBindViewHolder(holder: MensImageViewHolder, position: Int) {
        holder.bindView(images[position], listener)
    }
}