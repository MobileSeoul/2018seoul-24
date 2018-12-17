package com.naengjjambbong.hankangmoa.Jemin.Adapter

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.Glide
import com.naengjjambbong.hankangmoa.Jemin.Item.MainListItem
import com.naengjjambbong.hankangmoa.R


class MainImageAdapter internal constructor(internal var context: Context, var requestManager: RequestManager, var data : ArrayList<MainListItem>) : PagerAdapter() {


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.view_pager_main_list, null)
        val image_container = v.findViewById(R.id.view_pager_main_img) as ImageView


        //Glide.with(context).load(data[position].mainListImage).override(360,200).into(image_container)
        Glide.with(context).load(data[position].mainListImage).error(R.drawable.example_content).into(image_container)


//            image_container.layoutParams = LinearLayout.LayoutParams(200, 100);

        container.addView(v)

        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return 8
    }
}