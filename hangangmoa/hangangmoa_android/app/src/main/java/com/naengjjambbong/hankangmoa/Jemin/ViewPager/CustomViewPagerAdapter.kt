package com.naengjjambbong.hankangmoa.Jemin.ViewPager

import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.View
import android.view.ViewGroup

class CustomViewPagerAdapter(var adapter: PagerAdapter) : PagerAdapter() {


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return adapter.isViewFromObject(view, `object`)
    }

    override fun getCount(): Int {
        if(getRealCount() == 0){
            return 0
        }

        return Integer.MAX_VALUE
    }

    fun getRealCount() : Int{
        return adapter.count
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var virtualPosition = position % getRealCount()
        Log.v("asdf","추가 포지션 = " + virtualPosition)
        return adapter.instantiateItem(container, virtualPosition)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        var virtualPosition = position % getRealCount()
        Log.v("asdf","삭제 포지션 = " + virtualPosition)
        adapter.destroyItem(container, virtualPosition, `object`)
    }

    override fun getItemPosition(`object`: Any): Int {
        return adapter.getItemPosition(`object`)
    }
}