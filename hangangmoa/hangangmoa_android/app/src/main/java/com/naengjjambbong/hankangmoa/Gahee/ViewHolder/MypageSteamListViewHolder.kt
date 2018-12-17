package com.naengjjambbong.hankangmoa.Gahee.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.naengjjambbong.hankangmoa.R

class MypageSteamListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){

    var mpImage : ImageView = itemView!!.findViewById(R.id.festival_img) as ImageView

    var mpName : TextView = itemView!!.findViewById(R.id.festival_name)

    var mpDate : TextView = itemView!!.findViewById(R.id.date)

    var mpPlace : TextView = itemView!!.findViewById(R.id.place)
}