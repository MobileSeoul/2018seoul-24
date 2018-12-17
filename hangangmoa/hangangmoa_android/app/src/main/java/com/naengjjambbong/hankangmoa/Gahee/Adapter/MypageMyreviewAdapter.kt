package com.naengjjambbong.hankangmoa.Gahee.Adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Item.MypageMyreviewItem
import com.naengjjambbong.hankangmoa.Gahee.Item.ReviewItem
import com.naengjjambbong.hankangmoa.Gahee.ViewHolder.MypageMyreviewViewHolder
import com.naengjjambbong.hankangmoa.Gahee.ViewHolder.ReviewViewHolder
import com.naengjjambbong.hankangmoa.R


class MypageMyreviewAdapter(private var mypagemyreviewitems : ArrayList<MypageMyreviewItem>, var requestManager : RequestManager) :
        RecyclerView.Adapter<MypageMyreviewViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MypageMyreviewViewHolder {

        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_mypage_review, parent, false)
        return MypageMyreviewViewHolder(mainView)
    }

    override fun getItemCount(): Int = mypagemyreviewitems.size

    override fun onBindViewHolder(holder: MypageMyreviewViewHolder, position: Int) {
        holder.myreviewEventName.text=mypagemyreviewitems[position].myrevieweventname
        requestManager.load(mypagemyreviewitems[position].myreviewprofileURL).into(holder.myreviewProfileImage)
        holder.myreviewName.text = mypagemyreviewitems[position].myreviewuserid
        holder.myreviewDetail.text = mypagemyreviewitems[position].myreview

        if(mypagemyreviewitems[position].myreviewimg == null){
            holder.myreviewImage.visibility = View.GONE
            Log.v("asdf","사진 없음")
        }
        else{
            holder.myreviewImage.visibility = View.VISIBLE
        }

        requestManager.load(mypagemyreviewitems[position].myreviewimg).into(holder.myreviewImage)
        holder.myreviewDate.text = mypagemyreviewitems[position].myreviewdate
    }

}