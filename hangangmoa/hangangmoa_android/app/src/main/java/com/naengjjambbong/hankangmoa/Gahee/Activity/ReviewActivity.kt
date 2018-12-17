package com.naengjjambbong.hankangmoa.Gahee.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Adapter.ReviewAdapter
import com.naengjjambbong.hankangmoa.Gahee.Item.ReviewItem
import com.naengjjambbong.hankangmoa.R
import com.naengjjambbong.hankangmoa.R.layout.item_mypage_review
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_review.*
import kotlinx.android.synthetic.main.fragment_mypage_myreview.*
import kotlinx.android.synthetic.main.fragment_mypage_myreview.view.*

class ReviewActivity : AppCompatActivity() {

    lateinit var reviewItem: ArrayList<ReviewItem>
    lateinit var reviewAdapter: ReviewAdapter
    lateinit var requestManager: RequestManager //RequestManger는 이미지 주소를 URL로 가져오면서 사용함

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        review_activity_btn_write_img.setOnClickListener{
            var intent = Intent(this, ReviewWritingActivity::class.java)
            startActivity(intent)

        }

        reviewItem = ArrayList()
        review()
    }

    fun review() {
        requestManager = Glide.with(this)
        reviewItem.add(ReviewItem("https://i.pinimg.com/originals/f7/d8/97/f7d8977935a3ef91038141f04e7e759c.png","김지혜", "풍경이 너무 예쁜 것 같아요~",null,"2017.12.29"))
        reviewItem.add(ReviewItem("https://i.pinimg.com/originals/f7/d8/97/f7d8977935a3ef91038141f04e7e759c.png","이재란", "시적 순간의 생명력으로 재창조했다. 그만의 고유한 방식으로 촬영된 ‘필름다이어리’ 작품들은 지나간 시간들에 살아 움직이는 이미지의 숨결을 불어넣는다. 덧없이 찰나...","https://images.kbench.com/kbench/article/2011_04/k99180p1n7.jpg","2017.12.23"))
        reviewItem.add(ReviewItem("https://i.pinimg.com/originals/f7/d8/97/f7d8977935a3ef91038141f04e7e759c.png","유가희", "ㅎㅎㅎㅎ너무 좋은 것 같아용 한번 가보세용","http://love.seoul.go.kr/pds/Board/seoul_news_write/201708_12_1.jpg","2017.12.29" ))

        //projectItems.add(ProjectItem("https://project-cowalker.s3.ap-northeast-2.amazonaws.com/1531113346984.jpg", "ㅁㄴㅇㅎ", "ㅁㄴㅇㄹㄴㅁㅇㅎ", "ㅁㄴㅇㄹ", "ㅇㅎㅁㄴㅇㄹ"))ㅇ
        reviewAdapter = ReviewAdapter(reviewItem, requestManager)

        item_review_activity.layoutManager = LinearLayoutManager(this)
        item_review_activity.adapter = reviewAdapter

    }
}