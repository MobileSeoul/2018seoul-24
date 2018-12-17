package com.naengjjambbong.hankangmoa.Gahee.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Adapter.MypageSteamListAdapter
import com.naengjjambbong.hankangmoa.Gahee.Item.MypageSteamListItem
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.fragment_mypage_steamlist.view.*

class MypageSteamListFragment : Fragment() {

    lateinit var mypageSteamListItem: ArrayList<MypageSteamListItem>
    lateinit var mypageSteamListAdapter: MypageSteamListAdapter
    lateinit var requestManager: RequestManager //RequestManger는 이미지 주소를 URL로 가져오면서 사용함

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_mypage_steamlist, container, false)
        // Inflate the layout for this fragment

        mypageSteamListItem = ArrayList()
        mypage(v)
        return v
    }

    fun mypage(v : View){
        requestManager = Glide.with(this)//Glide는 뭐야?
        mypageSteamListItem.add(MypageSteamListItem("https://cdn.univ20.com/wp-content/uploads/2016/09/eaf418aefb7a9c97a6abeff9e7d827a0-1.jpg", "한강불꽃축제","2018.04.02~","잠실한강공원" ))
        mypageSteamListItem.add(MypageSteamListItem("https://img1.daumcdn.net/thumb/S600x434/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/mediaseoul/c633692445db4724984a654ae2ee8c03.JPG", "예빛섬 영화제","2028.04.02~","잠실한강공원" ))
        mypageSteamListItem.add(MypageSteamListItem("http://love.seoul.go.kr/pds/Board/seoul_news_write/201708_12_1.jpg", "한강 다리밑 영화제","2019.04.02~","나루원" ))
        mypageSteamListItem.add(MypageSteamListItem("http://image.kmib.co.kr/online_image/2016/0117/201601171739_61120010263499_1.jpg", "한강 수영장 오픈", "2018. 08. 07","잠실"))
        mypageSteamListItem.add(MypageSteamListItem("http://cfile221.uf.daum.net/image/990B2E425B56D2680DD609", "2018 한강 망년회", "2018. 12. 27","뚝섬"))
        //projectItems.add(ProjectItem("https://project-cowalker.s3.ap-northeast-2.amazonaws.com/1531113346984.jpg", "ㅁㄴㅇㅎ", "ㅁㄴㅇㄹㄴㅁㅇㅎ", "ㅁㄴㅇㄹ", "ㅇㅎㅁㄴㅇㄹ"))ㅇ
        mypageSteamListAdapter = MypageSteamListAdapter(mypageSteamListItem, requestManager)
        v.mypage_steamlist_recyclerview.layoutManager = LinearLayoutManager(v.context!!)
        v.mypage_steamlist_recyclerview.adapter = mypageSteamListAdapter

    }
}