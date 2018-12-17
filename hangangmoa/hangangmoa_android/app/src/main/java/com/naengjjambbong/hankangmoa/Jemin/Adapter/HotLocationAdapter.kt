package com.naengjjambbong.hankangmoa.Jemin.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Activity.DetailActivity
import com.naengjjambbong.hankangmoa.Jemin.Item.HotLocationItem
import com.naengjjambbong.hankangmoa.Jemin.ViewHolder.HotLocationViewHolder
import com.naengjjambbong.hankangmoa.R

class HotLocationAdapter(context : Context, private var hotLocationItem : ArrayList<HotLocationItem>, var requestManager : RequestManager) : RecyclerView.Adapter<HotLocationViewHolder>() {

    var mContext : Context = context
    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener){
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotLocationViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home_hot_location, parent, false)

        return HotLocationViewHolder(mainView)

    }

    override fun getItemCount(): Int = hotLocationItem.size

    override fun onBindViewHolder(holder: HotLocationViewHolder, position: Int) {
        requestManager.load(hotLocationItem[position].HotLocationImageUrl).into(holder.hotLocationImage)
        //requestManager.load(hotLocationItem[position].HotLocationImageUrl).error(R.drawable.btn_heart).into(holder.hotLocationImage)
        holder.hotLocationName.text = hotLocationItem[position].HotActivityName

        holder.itemView.setOnClickListener {
            var intent = Intent(mContext, DetailActivity::class.java)
            mContext.startActivity(intent)
        }
    }

}