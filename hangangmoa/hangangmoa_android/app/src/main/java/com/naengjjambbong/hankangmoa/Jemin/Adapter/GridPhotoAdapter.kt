package com.naengjjambbong.hankangmoa.Jemin.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Jemin.Item.GridPhotoItem
import com.naengjjambbong.hankangmoa.Jemin.Item.HotActivityItem
import com.naengjjambbong.hankangmoa.Jemin.Item.PhotoCategoryItem
import com.naengjjambbong.hankangmoa.Jemin.ViewHolder.GridPhotoViewHolder
import com.naengjjambbong.hankangmoa.Jemin.ViewHolder.HotActivityViewHolder
import com.naengjjambbong.hankangmoa.Jemin.ViewHolder.PhotoCategoryViewHolder
import com.naengjjambbong.hankangmoa.R

class GridPhotoAdapter(private var gridPhotoItem : ArrayList<GridPhotoItem>, var requestManager : RequestManager) : RecyclerView.Adapter<GridPhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridPhotoViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_grid_photo, parent, false)
        return GridPhotoViewHolder(mainView)

    }

    override fun getItemCount(): Int = gridPhotoItem.size

    override fun onBindViewHolder(holder: GridPhotoViewHolder, position: Int) {
        requestManager.load(gridPhotoItem[position].gridPhotoImageUrl).into(holder.gridPhotoImage)
        //requestManager.load(hotActivityItem[position].HotActivityImageUrl).error(R.drawable.btn_heart).into(holder.hotActivityImage)
        holder.gridPhotoAddress.text = gridPhotoItem[position].gridPhotoAddress
        holder.gridPhotoMakerName.text = gridPhotoItem[position].gridPhotoMakterName

    }

}