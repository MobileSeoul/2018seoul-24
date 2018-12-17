package com.naengjjambbong.hankangmoa.Jemin.ViewPager

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.AttributeSet

class CustomViewPager(mContext : Context, attrs : AttributeSet? = null) : ViewPager(mContext, attrs){

    override fun setAdapter(adapter: PagerAdapter?) {
        super.setAdapter(adapter)
        currentItem = Integer.MAX_VALUE / 2
    }

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item,false)
    }

    override fun setCurrentItem(item: Int, smoothScroll: Boolean) {
        if(adapter!!.count == 0){
            super.setCurrentItem(item, smoothScroll)
            return
        }
        val _item = getOffsetAmount() + (item % adapter!!.count)
        super.setCurrentItem(_item, smoothScroll)
    }

    override fun getCurrentItem(): Int {
        if(adapter!!.count == 0){
            return super.getCurrentItem()
        }

        val position = super.getCurrentItem()

        if(adapter is CustomViewPagerAdapter){
            val infAdapter = adapter as CustomViewPagerAdapter
            return (position % infAdapter.getRealCount())
        }
        else{
            return super.getCurrentItem()
        }
    }

    private fun getOffsetAmount() : Int{
        if(adapter!!.count == 0){
            return 0
        }
        if(adapter is CustomViewPagerAdapter){
            val ctfAdapter = adapter as CustomViewPagerAdapter

            return ctfAdapter.getRealCount() * 100
        }
        else
            return 0
    }
}