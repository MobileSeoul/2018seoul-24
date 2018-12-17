package com.naengjjambbong.hankangmoa.Gahee.Adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Item.ReviewItem
import com.naengjjambbong.hankangmoa.Gahee.ViewHolder.ReviewViewHolder
import com.naengjjambbong.hankangmoa.R

class ReviewAdapter(private var reviewitems : ArrayList<ReviewItem>, var requestManager : RequestManager) :
        RecyclerView.Adapter<ReviewViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {

        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_review_activity, parent, false)
        return ReviewViewHolder(mainView)
    }

    override fun getItemCount(): Int = reviewitems.size

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        requestManager.load(reviewitems[position].profileURL).into(holder.reviewProfileImage)
        holder.reviewName.text = reviewitems[position].userid
        holder.reviewDetail.text = reviewitems[position].review
        if(reviewitems[position].reviewimg == null){
            holder.reviewImage.visibility = View.GONE
            Log.v("asdf","사진 없음")
        }
        else{
            holder.reviewImage.visibility = View.VISIBLE
        }
        requestManager.load(reviewitems[position].reviewimg).into(holder.reviewImage)
        holder.reviewDate.text = reviewitems[position].reviewdate
    }

}