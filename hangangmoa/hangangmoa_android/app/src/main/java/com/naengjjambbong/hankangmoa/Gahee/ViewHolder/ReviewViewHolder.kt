package com.naengjjambbong.hankangmoa.Gahee.ViewHolder

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.item_review_activity.view.*
import org.w3c.dom.Text

class ReviewViewHolder (itemView: View?) : RecyclerView.ViewHolder(itemView){

    var reviewProfileImage: ImageView = itemView!!.findViewById(R.id.item_review_profile_img)
    var reviewName : TextView = itemView!!.findViewById(R.id.item_review_user_id_tv)
    var reviewDetail : TextView = itemView!!.findViewById(R.id.item_review_tv)
    var reviewImage : ImageView = itemView!!.findViewById(R.id.item_review_picture_img)
    var reviewDate : TextView = itemView!!.findViewById(R.id.item_review_date_tv)


    var reviewStar1Image : ImageView = itemView!!.findViewById(R.id.item_review_star1_img)
    var reviewStar2Image : ImageView = itemView!!.findViewById(R.id.item_review_star2_img)
    var reviewStar3Image : ImageView = itemView!!.findViewById(R.id.item_review_star3_img)
    var reviewStar4Image : ImageView = itemView!!.findViewById(R.id.item_review_star4_img)
    var reviewStar5Image : ImageView = itemView!!.findViewById(R.id.item_review_star5_img)

}