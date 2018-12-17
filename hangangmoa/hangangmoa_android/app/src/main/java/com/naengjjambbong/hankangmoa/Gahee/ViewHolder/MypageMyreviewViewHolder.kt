package com.naengjjambbong.hankangmoa.Gahee.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.naengjjambbong.hankangmoa.R

class MypageMyreviewViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){

        var myreviewEventName : TextView = itemView!!.findViewById(R.id.mypage_review_eventname_tv)
        var myreviewProfileImage: ImageView = itemView!!.findViewById(R.id.item_mypge_review_profile_img)
        var myreviewName : TextView = itemView!!.findViewById(R.id.item_mypage_review_usertv)
        var myreviewDetail : TextView = itemView!!.findViewById(R.id.item_mypage_review_detail_tv)
        var myreviewImage : ImageView = itemView!!.findViewById(R.id.item_mypagereview_picture_img)
        var myreviewDate : TextView = itemView!!.findViewById(R.id.item_mypage_review_date_tv)


        var reviewStar1Image : ImageView = itemView!!.findViewById(R.id.item_mypage_star1_img)
        var reviewStar2Image : ImageView = itemView!!.findViewById(R.id.item_mypage_star2_img)
        var reviewStar3Image : ImageView = itemView!!.findViewById(R.id.item_mypage_star3_img)
        var reviewStar4Image : ImageView = itemView!!.findViewById(R.id.item_mypage_star4_img)
        var reviewStar5Image : ImageView = itemView!!.findViewById(R.id.item_mypage_star5_img)

    }