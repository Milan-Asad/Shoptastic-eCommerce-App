package com.example.JSON_Rest_API_products_test

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.Throwaway.ThrowawayDataItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_items.view.*
import kotlinx.android.synthetic.main.row_items_test.view.*
import java.util.Locale.Category



class MyAdapter (val context: Context, val testlist: List<ThrowawayDataItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // **********VIEWHOLDER STUFF**********
    // MAKING THE VIEW HOLDER AND LOCAL VARIABLES FOR BINDING
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var Description: TextView
        var thumbnailUrlImage: ImageView
        var Title: TextView
        var Review: TextView
        var Price: TextView

        // INITALISING VARIABLES AND ASSIGNING IT TO ITEMS IN UI XML
        init {
            Description = itemView.item_description
            thumbnailUrlImage = itemView.thumbnailUrlPhotoViewNew1
            Title = itemView.item_title
            Review = itemView.ReviewTxt
            Price = itemView.PriceTxt
        }

        // BINDING THE IMAGE
        fun bind(TestVal: ThrowawayDataItem) { // ThumbnailImages
            // MAKING VARIABLE FOR THE IMAGE
            val PicassoLoader = itemView.findViewById<ImageView>(R.id.thumbnailUrlPhotoViewNew1)

            // USING PICASSO LIBRARY TO LOAD IMAGES
            Picasso.get().load(TestVal.image).into(PicassoLoader)
        }


    }

    // ON CREATING THE VIEWHOLDER
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items_test, parent, false) // ASSIGNING THE LAYOUT XML
        return ViewHolder(itemView) // RETURNUNG THE VAR ABOVE (ASSIGNING THE LAYOUT XML UI)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // BINDING THE VARIABLES FROM BEFORE TO THE ACTUAL JSON DATA
        holder.Description.text = testlist[position].description
        holder.Title.text = testlist[position].title
        holder.Review.text = testlist[position].rating.toString() // TO STRING CALL REQUIRED SINCE THIS IS A DOUBLE
        holder.Price.text = testlist[position].price.toString()     // TO STRING CALL REQUIRED SINCE THIS IS A INT (TITLE ETC ARE STRINGS)

        // Log.D to check the response of how many items are displayed for debugging
        Log.d("Response", "List Count Response is: ${testlist.size} Items from API")

        // RETURNING SIZE OF TESTLIST (API DATA) TO XML POSITION
        return holder.bind(testlist[position])


    }

    override fun getItemCount(): Int {
        return testlist.size // RETURNING SIZE OF API DATA
    }





}

