package com.naengjjambbong.hankangmoa.Jemin.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Jemin.Adapter.GridPhotoAdapter
import com.naengjjambbong.hankangmoa.Jemin.Adapter.LinearPhotoAdapter
import com.naengjjambbong.hankangmoa.Jemin.Item.GridPhotoItem
import com.naengjjambbong.hankangmoa.Jemin.Item.LinearPhotoItem
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.fragment_photo_grid.view.*
import kotlinx.android.synthetic.main.fragment_photo_linear.view.*

class LinearPhotoFragment : Fragment() {

    var linearListItem = ArrayList<LinearPhotoItem>()
    lateinit var linearPhotoAdapter : LinearPhotoAdapter
    lateinit var requestManager: RequestManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_photo_linear, container, false)
        // Inflate the layout for this fragmen

        requestManager = Glide.with(this)

        getLinearList(v)


        return v
    }

    fun getLinearList(v: View){

        linearListItem.add(LinearPhotoItem("http://img.hani.co.kr/imgdb/resize/2017/0714/149993553405_20170714.JPG", "라이언", "http://mblogthumb1.phinf.naver.net/20160625_240/bjy0524_146683775176259uj4_JPEG/attachImage_312025754.jpeg?type=w800", 20, "꿀잼!!!", "http://image.chosun.com/sitedata/image/201708/14/2017081400843_4.jpg", "한강몽땅 종이배경주대회", "2018. 09. 01 ~ 2018. 09. 30", "잠실한강공원"))
        linearListItem.add(LinearPhotoItem("http://image.chosun.com/sitedata/image/201708/14/2017081401455_0.jpg", "어피치", "https://post-phinf.pstatic.net/MjAxNzA2MjlfMjU5/MDAxNDk4NzM5NzI3MjA0.Aon2aPyhufiwt9-Y21w0v1luZzlYnihR7Xcozypyf8Qg.QLFNlJRzJzd1TqWWSN0DyVeHxe8zsAxGc7PHwkNHy8gg.PNG/1483309553699.png?type=w1200", 10, "영화 졸잼탱!!!", null, null, null, "반포한강공원"))
        linearListItem.add(LinearPhotoItem("http://thumb.zumst.com/530x0/http://static.news.zumst.com/images/83/2015/07/17/PYH2015071706870001300_P2.jpg", "무지", "https://pbs.twimg.com/profile_images/3128861384/90eb3185385f6abf6c5124b18ac48db3_400x400.jpeg", 5, "물총싸움!!!", null, null, null, "반포한강공원"))
        linearListItem.add(LinearPhotoItem("http://img.hani.co.kr/imgdb/resize/2017/0924/00500788_20170924.JPG", "튜브", "http://mblogthumb3.phinf.naver.net/20150311_30/tokyobeads3_1426047254763Y1CjA_PNG/9.PNG?type=w2", 30, "불꽃 축제!!!", "http://tong.visitkorea.or.kr/cms/resource/32/2500132_image2_1.jpg", "한강 불꽃축제 2018", "2018. 10. 06 ~ 2018. 10. 06", "여의도한강공원"))
        linearListItem.add(LinearPhotoItem("http://thumb.zumst.com/530x0/http://static.news.zumst.com/images/83/2015/07/17/PYH2015071706870001300_P2.jpg", "무지", "https://pbs.twimg.com/profile_images/3128861384/90eb3185385f6abf6c5124b18ac48db3_400x400.jpeg", 5, "물총싸움!!!", null, null, null, "반포한강공원"))
        linearPhotoAdapter = LinearPhotoAdapter(context!!, linearListItem, requestManager)
        v.linear_photo_recyclerview.layoutManager = LinearLayoutManager(v.context)
        v.linear_photo_recyclerview.adapter = linearPhotoAdapter
    }
}