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


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userId: TextView
        var thumbnailUrlImage: ImageView
        var userTitle: TextView
        var Category: TextView
        var Price: TextView


        /* RecyclerView Onclick
        init {

            itemView.setOnClickListener{
                val intent = Intent(itemView.context, TestActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                itemView.context.startActivity(intent)

            }
        }
         */


        init {
            userId = itemView.item_description
            thumbnailUrlImage = itemView.thumbnailUrlPhotoViewNew1
            userTitle = itemView.item_title
            Category = itemView.ReviewTxt
            Price = itemView.PriceTxt

            //userId = itemView.userId
            //thumbnailUrlImage = itemView.thumbnailUrlPhotoViewNew
            //userTitle = itemView.user_title

            //var thumbnailUrlPhoto = itemView.findViewById<ImageView>(R.id.thumbnailUrlPhotoView)
            var imageView1 = itemView.findViewById<ImageView>(R.id.thumbnailUrlPhotoViewNew)



        }

//        init {
//            itemView.setOnClickListener{
//                val intent = Intent(itemView.context, TestActivity::class.java)
//                itemView.context.startActivity(intent)
//            }
//        }

        fun bind(TestVal: ThrowawayDataItem) { // ThumbnailImages
            //var thumbnailUrlPhoto = itemView.findViewById<ImageView>(R.id.thumbnailUrlPhotoView)
            val imageView12 = itemView.findViewById<ImageView>(R.id.thumbnailUrlPhotoViewNew1)



            Picasso.get().load(TestVal.image).into(imageView12)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items_test, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = testlist[position].description
        holder.userTitle.text = testlist[position].title
        holder.Category.text = testlist[position].rating.toString()
        holder.Price.text = testlist[position].price.toString()

        //holder.userId.text = testlist[position].title
        //holder.userTitle.text = testlist[position].description

        Log.d("Response", "List Count :${testlist.size} ")
        return holder.bind(testlist[position])


    }

    override fun getItemCount(): Int {
        return testlist.size
    }





}

