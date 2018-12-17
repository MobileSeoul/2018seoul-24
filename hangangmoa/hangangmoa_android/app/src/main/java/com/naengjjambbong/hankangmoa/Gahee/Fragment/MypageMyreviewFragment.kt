package com.naengjjambbong.hankangmoa.Gahee.Fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Activity.ReviewWritingActivity
import com.naengjjambbong.hankangmoa.Gahee.Adapter.MypageMyreviewAdapter
import com.naengjjambbong.hankangmoa.Gahee.Adapter.ReviewAdapter
import com.naengjjambbong.hankangmoa.Gahee.Item.MypageMyreviewItem
import com.naengjjambbong.hankangmoa.Gahee.Item.ReviewItem
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.activity_review.*
import kotlinx.android.synthetic.main.fragment_mypage_myreview.*
import kotlinx.android.synthetic.main.fragment_mypage_myreview.view.*

class MypageMyreviewFragment : Fragment() {

    lateinit var mypagemyreviewItem: ArrayList<MypageMyreviewItem>
    lateinit var mypagemyreviewAdapter: MypageMyreviewAdapter
    lateinit var requestManager: RequestManager //RequestManger는 이미지 주소를 URL로 가져오면서 사용함


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_mypage_myreview, container, false)
        // Inflate the layout for this fragment

        review(v)
        return v
    }

    fun review(v : View) {
        requestManager = Glide.with(this)
        mypagemyreviewItem = ArrayList()
        mypagemyreviewItem.add(MypageMyreviewItem("한강몽땅 종이배 경주대회","https://i.pinimg.com/originals/f7/d8/97/f7d8977935a3ef91038141f04e7e759c.png","김지혜", "시적 순간의 생명력으로 재창조했다. 그만의 고유한 방식으로 촬영된 ‘필름다이어리’ 작품들은 지나간 시간들에 살아 움직이는 이미지의 숨결을 불어넣는다. 덧없이 찰나...",null,"2017.12.29" ))
        mypagemyreviewItem.add(MypageMyreviewItem("한강 불꽃 축제","https://i.pinimg.com/originals/f7/d8/97/f7d8977935a3ef91038141f04e7e759c.png","이재란", "풍경이 너무 예쁜 것 같아요~","https://cdn.univ20.com/wp-content/uploads/2016/09/eaf418aefb7a9c97a6abeff9e7d827a0-1.jpg","2017.12.23" ))
        mypagemyreviewItem.add(MypageMyreviewItem("어벤져스","https://i.pinimg.com/originals/f7/d8/97/f7d8977935a3ef91038141f04e7e759c.png","유가희", "어벤져스 완전 꿀잼!!! 누구든 환영!! 체험해봐요오!",null,"2017.12.29" ))

        //projectItems.add(ProjectItem("https://project-cowalker.s3.ap-northeast-2.amazonaws.com/1531113346984.jpg", "ㅁㄴㅇㅎ", "ㅁㄴㅇㄹㄴㅁㅇㅎ", "ㅁㄴㅇㄹ", "ㅇㅎㅁㄴㅇㄹ"))ㅇ
        mypagemyreviewAdapter = MypageMyreviewAdapter(mypagemyreviewItem, requestManager)

        v.mypage_myreview_recyclerview.layoutManager = LinearLayoutManager(context)
        v.mypage_myreview_recyclerview.adapter = mypagemyreviewAdapter

    }
}