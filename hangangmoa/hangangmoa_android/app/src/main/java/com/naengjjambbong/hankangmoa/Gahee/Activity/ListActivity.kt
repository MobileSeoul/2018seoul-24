package com.naengjjambbong.hankangmoa.Gahee.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Adapter.ListAdapter
import com.naengjjambbong.hankangmoa.Gahee.Item.ListItem
import com.naengjjambbong.hankangmoa.R
import com.naengjjambbong.hankangmoa.R.id.list_recyclerView
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : AppCompatActivity() {
    lateinit var listItem: ArrayList<ListItem>
    lateinit var listAdapter: ListAdapter
    lateinit var requestManager: RequestManager //RequestManger는 이미지 주소를 URL로 가져오면서 사용함

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listItem = ArrayList()
        list()
    }

    fun list(){
        requestManager = Glide.with(this)//Glide는 뭐야?
        listItem.add(ListItem("3.5","한강 다리밑 영화제", "2018.08.10(금) ~ 08.12(일)" ))
        listItem.add(ListItem("4", "예빛섬 영화제","2018.08.10(금) ~ 08.12(일)" ))
        listItem.add(ListItem("4","한강 퍼펫파크","2018.08.10(금) ~ 08.12(일)" ))

        //projectItems.add(ProjectItem("https://project-cowalker.s3.ap-northeast-2.amazonaws.com/1531113346984.jpg", "ㅁㄴㅇㅎ", "ㅁㄴㅇㄹㄴㅁㅇㅎ", "ㅁㄴㅇㄹ", "ㅇㅎㅁㄴㅇㄹ"))ㅇ
       listAdapter = ListAdapter(listItem, requestManager)
        list_recyclerView.layoutManager = LinearLayoutManager(this)
        list_recyclerView.adapter = listAdapter

    }

}
