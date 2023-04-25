package com.example.JSON_Rest_API_products_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeetTheTeamAdapter: RecyclerView.Adapter<MeetTheTeamAdapter.ViewHolder>() {

    // MAKING THE VARIABLES (IN ARRAYS FORMAT)
    private var StaffName = arrayOf("Jonathan Fellows", "Lucy Fellows", "Lucy-Fraser Alexander", "Darron Murphy", "Gary Parker", "Rob Geller", "Selena Rose", "Alex McWight", "Simone Wolf",)
    private var StaffRole = arrayOf("CEO of Shoptastic", "Vice President", "Head of International Relations", "Chief Market Strategist Officer", "Head of Financial Operations", "Chief Fashion Designer", "Fashion Designer", "Fashion Designer", "Head of Marketing and Public Relations",)
    private var StaffImages = intArrayOf(R.drawable.aiface2, R.drawable.aiface, R.drawable.aiface6, R.drawable.aiface4, R.drawable.aiface5, R.drawable.aiface3, R.drawable.aiface7, R.drawable.aiface8, R.drawable.aiface9,)
    private var StaffReferenceNumber = arrayOf("REFERENCE NUMBER: DEC1312", "REFERENCE NUMBER: F1YF00D", "REFERENCE NUMBER: MBF3574", "REFERENCE NUMBER: YUG6483", "REFERENCE NUMBER: RTV5382", "REFERENCE NUMBER: FGF54639", "REFERENCE NUMBER: AGH6739", "REFERENCE NUMBER: FAT40004", "REFERENCE NUMBER: TSF7474", "REFERENCE NUMBER: DEZ8374")

    // GIVING ITS ID
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var staff_name: TextView
        var staff_role: TextView
        var staff_images: ImageView
        var staff_reference_number: TextView

        //FINDVIEWBY ID
        init{
            staff_name = itemView.findViewById(R.id.staff_name)
            staff_role = itemView.findViewById(R.id.staff_role)
            staff_images = itemView.findViewById(R.id.staff_image)
            staff_reference_number = itemView.findViewById(R.id.staff_ref_number)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetTheTeamAdapter.ViewHolder {
        // TO ADD THE CARDVIEW WE MADE
        val v = LayoutInflater.from(parent.context).inflate(R.layout.meet_the_team_cardview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // ASSIGNING OUR VARIABLES TO THE XML ITEM
        holder.staff_name.text = StaffName[position]
        holder.staff_role.text = StaffRole[position]
        holder.staff_images.setImageResource(StaffImages[position])
        holder.staff_reference_number.text = StaffReferenceNumber[position]

    }

    override fun getItemCount(): Int {

        // RETURN IT TO DISPLAY
        return StaffName.size

    }
}