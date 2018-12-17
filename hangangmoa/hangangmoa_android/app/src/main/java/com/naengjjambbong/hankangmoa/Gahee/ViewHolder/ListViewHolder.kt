package com.naengjjambbong.hankangmoa.Gahee.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.naengjjambbong.hankangmoa.R

class ListViewHolder (itemView: View?) : RecyclerView.ViewHolder(itemView){

    var list_score : TextView = itemView!!.findViewById(R.id.list_score)

    var list_name : TextView = itemView!!.findViewById(R.id.list_name)

    var list_date : TextView = itemView!!.findViewById(R.id.list_date)
}