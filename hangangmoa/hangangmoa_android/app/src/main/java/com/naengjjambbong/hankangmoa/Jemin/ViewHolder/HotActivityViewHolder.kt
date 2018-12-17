package com.naengjjambbong.hankangmoa.Jemin.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.view.animation.AnimationUtils
import com.naengjjambbong.hankangmoa.R


class HotActivityViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {

    var lastPosition = -1
    var hotActivityImage: ImageView = itemView!!.findViewById(R.id.item_hot_activity_img)
    var hotActivityName: TextView = itemView!!.findViewById(R.id.item_hot_activity_name_tv)
    var hotDateRange: TextView = itemView!!.findViewById(R.id.item_hot_date_range_tv)

}