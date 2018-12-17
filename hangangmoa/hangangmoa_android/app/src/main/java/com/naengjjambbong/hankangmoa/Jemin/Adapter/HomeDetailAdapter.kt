package com.naengjjambbong.hankangmoa.Jemin.Adapter

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Jemin.Item.GridPhotoItem
import com.naengjjambbong.hankangmoa.Jemin.Item.HomeDetailItem
import com.naengjjambbong.hankangmoa.Jemin.Item.MongDDangItem
import com.naengjjambbong.hankangmoa.Jemin.ViewHolder.GridPhotoViewHolder
import com.naengjjambbong.hankangmoa.Jemin.ViewHolder.HomeDetailViewHolder
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.view_pager_main_list.view.*

class HomeDetailAdapter(context : Context, private var homeDetailItem : ArrayList<MongDDangItem>, var requestManager : RequestManager) : RecyclerView.Adapter<HomeDetailViewHolder>() {
    val  mContext : Context = context
    private lateinit var onItemClick : View.OnClickListener
    var heartFlag : Int = 0

    fun setOnItemClickListener(l : View.OnClickListener){
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDetailViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home_detail, parent, false)
        mainView.setOnClickListener(onItemClick)
        return HomeDetailViewHolder(mainView)

    }

    override fun getItemCount(): Int = homeDetailItem.size

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: HomeDetailViewHolder, position: Int) {
        requestManager.load(homeDetailItem[position].homeDetailActivityImgUrl).into(holder.homeDetailActivityImage)
        //requestManager.load(hotActivityItem[position].HotActivityImageUrl).error(R.drawable.btn_heart).into(holder.hotActivityImage)

        val drawable = mContext.getDrawable(R.drawable.background_rounding) as GradientDrawable

        holder.homeDetailActivityImage.background = drawable
        holder.homeDetailActivityImage.clipToOutline = true
        holder.homeDetailActivityName.text = homeDetailItem[position].homeDetailActivityName
        holder.homeDetailActivityRange.text = homeDetailItem[position].homeDetailActivityRange

        holder.homeDetailActivityHearImage.setOnClickListener {
            if(heartFlag == 0)
            {
                holder.homeDetailActivityHearImage.isSelected = true
                heartFlag = 1
            }
            else{
                holder.homeDetailActivityHearImage.isSelected = false
                heartFlag = 0
            }
        }

        //holder.homeDetailActivityCount.text = homeDetailItem[position].homeDetailActivityCount.toString()

    }

}