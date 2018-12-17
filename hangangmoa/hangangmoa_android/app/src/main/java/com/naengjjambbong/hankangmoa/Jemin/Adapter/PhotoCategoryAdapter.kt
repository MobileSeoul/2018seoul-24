package com.naengjjambbong.hankangmoa.Jemin.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Jemin.Item.HotActivityItem
import com.naengjjambbong.hankangmoa.Jemin.Item.PhotoCategoryItem
import com.naengjjambbong.hankangmoa.Jemin.ViewHolder.HotActivityViewHolder
import com.naengjjambbong.hankangmoa.Jemin.ViewHolder.PhotoCategoryViewHolder
import com.naengjjambbong.hankangmoa.R

class PhotoCategoryAdapter(private var photoCategoryItem : ArrayList<PhotoCategoryItem>, var requestManager : RequestManager) : RecyclerView.Adapter<PhotoCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoCategoryViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_photo_category, parent, false)
        return PhotoCategoryViewHolder(mainView)

    }

    override fun getItemCount(): Int = photoCategoryItem.size

    override fun onBindViewHolder(holder: PhotoCategoryViewHolder, position: Int) {
        requestManager.load(photoCategoryItem[position].photoCategoryImageUrl).into(holder.photoCateogryImage)
        //requestManager.load(hotActivityItem[position].HotActivityImageUrl).error(R.drawable.btn_heart).into(holder.hotActivityImage)
        holder.photoCategoryName.text = photoCategoryItem[position].photoCategoryName

    }

}