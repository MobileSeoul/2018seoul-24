package com.naengjjambbong.hankangmoa.Jemin.Adapter

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.view.ViewPager
import android.view.View

class CardPagerTransformerShift(var baseElevation : Float, var raisingElevation : Float, var smallerScale : Float, var startOffset : Float) : ViewPager.PageTransformer {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun transformPage(page: View, position: Float) {
        var absPosition = Math.abs(position - startOffset)

        if(absPosition >= 1){
            page.elevation = baseElevation
            page.scaleY = smallerScale
            page.scaleX = smallerScale
            page.isClickable = false
        }
        else if(absPosition == 0f){
            page.isClickable = true
        }
        else{
            page.elevation = (1-absPosition) * raisingElevation + baseElevation
            page.scaleY = (smallerScale - 1) * absPosition + 1
            page.scaleX = (smallerScale - 1) * absPosition + 1
            page.isClickable = false
        }

    }

}