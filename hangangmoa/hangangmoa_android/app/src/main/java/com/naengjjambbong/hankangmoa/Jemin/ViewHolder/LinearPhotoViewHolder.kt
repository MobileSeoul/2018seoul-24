package com.naengjjambbong.hankangmoa.Jemin.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.naengjjambbong.hankangmoa.R

class LinearPhotoViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {

    var linearPhotoImage: ImageView = itemView!!.findViewById(R.id.linear_photo_background_img)
    var linearPhotoMakerName: TextView = itemView!!.findViewById(R.id.linear_photo_maker_name_tv)
    var linearPhotoMakerImageUrl: ImageView = itemView!!.findViewById(R.id.linear_photo_maker_img)
    var linearPhotoHeartCount: TextView = itemView!!.findViewById(R.id.linear_photo_heart_count_tv)
    var linearPhotoHeartBtn: Button = itemView!!.findViewById(R.id.linear_photo_heart_btn)
    var linearPhotoReview: TextView = itemView!!.findViewById(R.id.linear_photo_review_tv)
    var linearDetailContentImageUrl: ImageView = itemView!!.findViewById(R.id.linear_detail_activity_explain_img)
    var linearDetailContentName: TextView = itemView!!.findViewById(R.id.linear_detail_activity_name_tv)
    var linearDetailContentRange: TextView = itemView!!.findViewById(R.id.linear_detail_activity_range_tv)
    var linearDetailContentAddress: TextView = itemView!!.findViewById(R.id.linear_detail_activity_address_tv)

    var linearSmallContentAddress: TextView = itemView!!.findViewById(R.id.linear_detail_small_activity_address_tv)


    var linearDetailLayout: RelativeLayout = itemView!!.findViewById(R.id.linear_detail_all_content_layout)
    var linearSmallLayout: RelativeLayout = itemView!!.findViewById(R.id.linear_detail_small_content_layout)

    var linearTrashLayout: LinearLayout = itemView!!.findViewById(R.id.linear_trash_layout)

}