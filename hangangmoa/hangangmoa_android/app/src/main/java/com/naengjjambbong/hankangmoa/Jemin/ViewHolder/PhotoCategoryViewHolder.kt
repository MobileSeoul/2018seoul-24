package com.naengjjambbong.hankangmoa.Jemin.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.view.animation.AnimationUtils
import com.naengjjambbong.hankangmoa.R


class PhotoCategoryViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {

    var photoCateogryImage: ImageView = itemView!!.findViewById(R.id.item_photo_category_img)
    var photoCategoryName: TextView = itemView!!.findViewById(R.id.item_photo_category_name_tv)

}