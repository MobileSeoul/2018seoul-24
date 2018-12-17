package com.naengjjambbong.hankangmoa.Jemin.Fragment.CategoryTab.SportCategory

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Activity.DetailActivity
import com.naengjjambbong.hankangmoa.Jemin.Adapter.HomeDetailAdapter
import com.naengjjambbong.hankangmoa.Jemin.Item.MongDDangItem
import com.naengjjambbong.hankangmoa.Network.Get.GetInlineMessage
import com.naengjjambbong.hankangmoa.Network.Get.GetJokguMessage
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetImageSearchResponse
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetJokguResponse
import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetInlineRowData
import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetJokguRowData
import com.naengjjambbong.hankangmoa.Network.RestApplicationController
import com.naengjjambbong.hankangmoa.Network.RestNetworkService
import com.naengjjambbong.hankangmoa.Network.SeoulApiController
import com.naengjjambbong.hankangmoa.Network.SeoulNetworkService
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.fragment_sport.*
import kotlinx.android.synthetic.main.fragment_sport.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class JokguTab : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        val idx : Int = tab_sport_recyclerview.getChildAdapterPosition(v)
        Log.v("TAG","클릭이벤트 감지 포지션 = " + idx)

        val intent = Intent(getActivity(), DetailActivity::class.java)
        startActivity(intent)
    }

    lateinit var seoulNetworkService : SeoulNetworkService
    lateinit var restNetworkService : RestNetworkService

    lateinit var homeDetailAdapter : HomeDetailAdapter
    lateinit var requestManager: RequestManager

    lateinit var jokguRow : GetJokguMessage
    lateinit var jokguData : ArrayList<GetJokguRowData>
    var jokguItem = ArrayList<MongDDangItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_sport, container, false)//지도

        requestManager = Glide.with(this)
        getjokguList(v)
        return v
    }

    private fun getjokguList(v : View) {

        var key : String = "4b516c61757770613438466a464855"

        var pageNo = 4
        try {
            seoulNetworkService = SeoulApiController.getRetrofit().create(SeoulNetworkService::class.java)
            var getjokguResponse = seoulNetworkService.getJokguList(key, pageNo) // 네트워크 서비스의 getContent 함수를 받아옴
            Log.v("TAG","서울시 족구장 데이터 GET 통신 시작 전")
            getjokguResponse.enqueue(object : Callback<GetJokguResponse> {
                override fun onResponse(call: Call<GetJokguResponse>?, response: Response<GetJokguResponse>?) {
                    if(response!!.isSuccessful) {
                        Log.v("TAG","서울시 족구장 데이터 GET 통신 성공")
                        jokguRow = response!!.body()!!.GeoInfoJokguWGS

                        jokguData = jokguRow!!.row
                        if(jokguRow!!.row.size == 0)
                        {
                            Log.v("TAG","서울시 족구장 데이터 값 없음.")
                        }
                        else
                        {
                            for(i in 0..jokguData.size-1) {
                                Log.v("asdf", "족구장 데이터 [" + i + "] = " + jokguData[i].JONAME)
                                jokguItem.add(MongDDangItem(jokguData[i].JONAME, "", "null"))

                            }
                            imageSearch(v)
                        }
                    }
                }

                override fun onFailure(call: Call<GetJokguResponse>?, t: Throwable?) {
                    Log.v("TAG","서울시 족구장 데이터 통신 실패" + t.toString())
                }
            })
        } catch (e: Exception) {
        }

    }

    fun imageSearch(v : View) {

        restNetworkService = RestApplicationController.getRetrofit().create(RestNetworkService::class.java)
        Log.v("ASdf", "족구장 이미지 데이터 가져오기 시작")
        for (i in 0..jokguItem.size-1) {
            Log.v("TAG", "족구장 이미지 검색 통신 시작 전 = " + i)

            var getImageSearchResponse = restNetworkService.getImageSearch("KakaoAK 298be2e3612229355b9d2e28bb10912e", jokguItem[i].homeDetailActivityName!!)

            getImageSearchResponse.enqueue(object : Callback<GetImageSearchResponse> {
                override fun onResponse(call: Call<GetImageSearchResponse>?, response: Response<GetImageSearchResponse>?) {
                    Log.v("TAG", "족구장 이미지 검색 통신 시작")
                    if (response!!.isSuccessful) {

                        Log.v("TAG", "족구장 이미지 검색 통신 성공")

                        if (response!!.body()!!.documents!!.size == 0) {
                            jokguItem[i].homeDetailActivityImgUrl = "https://2.bp.blogspot.com/-a7VX4tT-g4k/WdEZ8eaDrWI/AAAAAAAC-mA/O5cw44tb1TMA7gJzhvnX8b1ObO0y80-tACLcBGAs/s1600/%25ED%2595%259C%25EA%25B0%2595%2B%25EA%25B8%25B8%25EC%259D%25B4.jpg"
                        } else {
                            jokguItem[i].homeDetailActivityImgUrl = response!!.body()!!.documents[0].image_url!!
                        }

                        if(i==jokguItem.size-1) {

                            if(context == null)
                            {
                                Log.v("Asdf","context is null")
                            }
                            else{
                                homeDetailAdapter = HomeDetailAdapter(context!!, jokguItem, requestManager)
                                homeDetailAdapter!!.setOnItemClickListener(this@JokguTab)
                                v.tab_sport_recyclerview.layoutManager = LinearLayoutManager(v.context)
                                v.tab_sport_recyclerview.adapter = homeDetailAdapter
                            }
                        }

                    } else {
                        Log.v("TAG", "족구장 이미지 검색 값 가져오기 실패")
                    }
                }

                override fun onFailure(call: Call<GetImageSearchResponse>?, t: Throwable?) {
                    Log.v("TAG", "족구장 이미지 서버 통신 실패" + t.toString())
                }

            })
        }


    }
}