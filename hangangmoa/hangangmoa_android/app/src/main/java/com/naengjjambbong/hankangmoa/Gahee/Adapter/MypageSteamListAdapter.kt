package com.naengjjambbong.hankangmoa.Gahee.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Item.MypageSteamListItem
import com.naengjjambbong.hankangmoa.Gahee.ViewHolder.MypageSteamListViewHolder
import com.naengjjambbong.hankangmoa.R

class MypageSteamListAdapter(private var mypageitems : ArrayList<MypageSteamListItem>, var requestManager : RequestManager) :
        RecyclerView.Adapter<MypageSteamListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MypageSteamListViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_mypage, parent, false)
        return MypageSteamListViewHolder(mainView)

    }

    override fun getItemCount(): Int = mypageitems.size

    override fun onBindViewHolder(holderSteamList: MypageSteamListViewHolder, position: Int) {
        requestManager.load(mypageitems[position].mpImageUrl).error(R.drawable.btn_heart).into(holderSteamList.mpImage)
        holderSteamList.mpName.text = mypageitems[position].mpname
        holderSteamList.mpDate.text = mypageitems[position].mpdate
        holderSteamList.mpPlace.text = mypageitems[position].mpplace
    }

}