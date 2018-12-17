package com.naengjjambbong.hankangmoa.Jemin.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.naengjjambbong.hankangmoa.R


class GridPhotoViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {

    var gridPhotoImage: ImageView = itemView!!.findViewById(R.id.grid_photo_img)
    var gridPhotoAddress: TextView = itemView!!.findViewById(R.id.grid_photo_address_tv)
    var gridPhotoMakerName: TextView = itemView!!.findViewById(R.id.grid_photo_maker_name_tv)

}