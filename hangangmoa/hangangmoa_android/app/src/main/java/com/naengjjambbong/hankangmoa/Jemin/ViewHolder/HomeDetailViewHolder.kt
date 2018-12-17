package com.naengjjambbong.hankangmoa.Jemin.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.naengjjambbong.hankangmoa.R

class HomeDetailViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {

    var homeDetailActivityImage: ImageView = itemView!!.findViewById(R.id.item_home_detail_background_img)
    var homeDetailActivityName: TextView = itemView!!.findViewById(R.id.item_home_detail_name_tv)
    var homeDetailActivityRange: TextView = itemView!!.findViewById(R.id.item_home_deatail_range_tv)
    var homeDetailActivityCount: TextView = itemView!!.findViewById(R.id.item_home_detail_count_tv)

    var homeDetailActivityHearImage : ImageView = itemView!!.findViewById(R.id.item_home_detail_heart_img)

    var homeDetailHeartImage: ImageView = itemView!!.findViewById(R.id.item_home_detail_heart_img)

    var homeDetailStart1Image: ImageView = itemView!!.findViewById(R.id.item_home_detail_star1_img)
    var homeDetailStart2Image: ImageView = itemView!!.findViewById(R.id.item_home_detail_star2_img)
    var homeDetailStart3Image: ImageView = itemView!!.findViewById(R.id.item_home_detail_star3_img)
    var homeDetailStart4Image: ImageView = itemView!!.findViewById(R.id.item_home_detail_star4_img)
    var homeDetailStart5Image: ImageView = itemView!!.findViewById(R.id.item_home_detail_star5_img)

}