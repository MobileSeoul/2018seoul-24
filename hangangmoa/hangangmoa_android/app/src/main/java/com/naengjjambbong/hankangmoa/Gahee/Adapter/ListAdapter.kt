package com.naengjjambbong.hankangmoa.Gahee.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Item.ListItem
import com.naengjjambbong.hankangmoa.Gahee.ViewHolder.ListViewHolder
import com.naengjjambbong.hankangmoa.R

class ListAdapter (private var listitems : ArrayList<ListItem>, var requestManager : RequestManager) :
        RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.list_recyclerview, parent, false)
        return ListViewHolder(mainView)

    }

    override fun getItemCount(): Int = listitems.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.list_score.text = listitems[position].listscore
        holder.list_name.text = listitems[position].listname
        holder.list_date.text = listitems[position].listdate
    }

}