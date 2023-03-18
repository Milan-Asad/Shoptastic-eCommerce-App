package com.example.JSON_Rest_API_products_test.UserData

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.JSON_Rest_API_products_test.R
import kotlinx.android.synthetic.main.row_items.view.*
import kotlinx.android.synthetic.main.row_items.view.user_name
import kotlinx.android.synthetic.main.userdata_card_layout.view.*


class UserAdapter (val context: Context, val userList: List<UserDataItem>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    class ViewHolder(itemView1: View): RecyclerView.ViewHolder(itemView1) {
        var name: TextView
        var email: TextView
        var username: TextView
        var password: TextView







        init {
            name = itemView1.user_name
            email = itemView1.user_email
            username = itemView1.user_username
            password = itemView1.user_password1





        }





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView1 = LayoutInflater.from(context).inflate(R.layout.userdata_card_layout, parent, false)
        return ViewHolder(itemView1)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = userList[position].name.firstname
        holder.email.text = userList[position].email
        holder.username.text = userList[position].username
        holder.password.text = userList[position].password

        //holder.userId.text = testlist[position].title
        //holder.userTitle.text = testlist[position].description

        Log.d("Response", "List Count :${userList.size} ")



    }

    override fun getItemCount(): Int {
        return userList.size
    }





}

