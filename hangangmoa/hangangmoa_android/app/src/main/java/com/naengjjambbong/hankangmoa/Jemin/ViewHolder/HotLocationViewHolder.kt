package com.naengjjambbong.hankangmoa.Jemin.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.naengjjambbong.hankangmoa.R

class HotLocationViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {

    var hotLocationImage : ImageView = itemView!!.findViewById(R.id.item_hot_location_img)
    var hotLocationName: TextView = itemView!!.findViewById(R.id.item_hot_location_name_tv)
}