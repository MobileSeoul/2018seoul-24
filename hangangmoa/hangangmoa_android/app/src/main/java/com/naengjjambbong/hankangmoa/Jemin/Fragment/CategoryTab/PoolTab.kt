package com.naengjjambbong.hankangmoa.Jemin.Fragment.CategoryTab

import android.content.Intent
import android.graphics.Color
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
import com.naengjjambbong.hankangmoa.Network.Get.GetPoolMessage
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetImageSearchResponse
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetPoolResponse
import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetPoolRowData
import com.naengjjambbong.hankangmoa.Network.RestApplicationController
import com.naengjjambbong.hankangmoa.Network.RestNetworkService
import com.naengjjambbong.hankangmoa.Network.SeoulApiController
import com.naengjjambbong.hankangmoa.Network.SeoulNetworkService
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.fragment_pooltab.*
import kotlinx.android.synthetic.main.fragment_pooltab.view.*
import kotlinx.android.synthetic.main.fragment_sport.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class PoolTab : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        val idx : Int = tab_pool_recyclerview.getChildAdapterPosition(v)
        Log.v("TAG","클릭이벤트 감지 포지션 = " + idx)

        val intent = Intent(getActivity(), DetailActivity::class.java)
        startActivity(intent)
    }

    // 수영장 데이터
    lateinit var poolRow : GetPoolMessage
    lateinit var poolData : ArrayList<GetPoolRowData>
    lateinit var seoulNetworkService : SeoulNetworkService
    lateinit var restNetworkService : RestNetworkService

    lateinit var homeDetailAdapter : HomeDetailAdapter
    lateinit var requestManager: RequestManager

    var poolProceedingItem = ArrayList<MongDDangItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_pooltab, container, false)//지도

        requestManager = Glide.with(this)
        v.pool_proceeding_btn.isSelected = true
        v.pool_proceeding_btn.setTextColor(Color.parseColor("#ffffff"))

        getPoolList(v)

        v.pool_proceeding_btn.setOnClickListener {

            v.pool_proceeding_btn.isSelected = true
            v.pool_proceeding_btn.setTextColor(Color.parseColor("#ffffff"))
            v.pool_stop_btn.isSelected = false
            v.pool_stop_btn.setTextColor(Color.parseColor("#000000"))

        }


        v.pool_stop_btn.setOnClickListener {

            v.pool_stop_btn.isSelected = true
            v.pool_stop_btn.setTextColor(Color.parseColor("#ffffff"))
            v.pool_proceeding_btn.isSelected = false
            v.pool_proceeding_btn.setTextColor(Color.parseColor("#000000"))
        }

        return v
    }

    private fun getPoolList(v : View) {

        var key : String = "6a56634f5077706135355749504a4d"

        var pageNo = 6
        try {
            seoulNetworkService = SeoulApiController.getRetrofit().create(SeoulNetworkService::class.java)
            var getPoolResponse = seoulNetworkService.getPoolList(key, pageNo) // 네트워크 서비스의 getContent 함수를 받아옴
            Log.v("TAG","서울시 수영장 데이터 GET 통신 시작 전")
            getPoolResponse.enqueue(object : Callback<GetPoolResponse> {
                override fun onResponse(call: Call<GetPoolResponse>?, response: Response<GetPoolResponse>?) {
                    if(response!!.isSuccessful) {
                        Log.v("TAG","서울시 수영장 데이터 GET 통신 성공")
                        poolRow = response!!.body()!!.GeoInfoPool

                        poolData = poolRow!!.row
                        if(poolRow!!.row.size == 0)
                        {
                            Log.v("TAG","서울시 수영장 데이터 값 없음.")
                        }
                        else
                        {
                            for(i in 0..poolData.size-1) {
                                Log.v("asdf", "수영장 데이터 [" + i + "] = " + poolData[i].POOLNAME)
                                poolProceedingItem.add(MongDDangItem(poolData[i].POOLNAME, "", "null"))
                                imageSearch(v)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<GetPoolResponse>?, t: Throwable?) {
                    Log.v("TAG","서울시 수영장 데이터 통신 실패" + t.toString())
                }
            })
        } catch (e: Exception) {
        }

    }

    fun imageSearch(v : View) {

        restNetworkService = RestApplicationController.getRetrofit().create(RestNetworkService::class.java)
        Log.v("ASdf", "수영장 이미지 데이터 가져오기 시작")
        for (i in 0..poolProceedingItem.size-1) {
            Log.v("TAG", "수영장 이미지 검색 통신 시작 전 = " + i)

            var getImageSearchResponse = restNetworkService.getImageSearch("KakaoAK 298be2e3612229355b9d2e28bb10912e", poolProceedingItem[i].homeDetailActivityName!!)

            getImageSearchResponse.enqueue(object : Callback<GetImageSearchResponse> {
                override fun onResponse(call: Call<GetImageSearchResponse>?, response: Response<GetImageSearchResponse>?) {
                    Log.v("TAG", "수영장 이미지 검색 통신 시작")
                    if (response!!.isSuccessful) {

                        Log.v("TAG", "수영장 이미지 검색 통신 성공")

                        if (response!!.body()!!.documents!!.size == 0) {
                            poolProceedingItem[i].homeDetailActivityImgUrl = "https://2.bp.blogspot.com/-a7VX4tT-g4k/WdEZ8eaDrWI/AAAAAAAC-mA/O5cw44tb1TMA7gJzhvnX8b1ObO0y80-tACLcBGAs/s1600/%25ED%2595%259C%25EA%25B0%2595%2B%25EA%25B8%25B8%25EC%259D%25B4.jpg"
                        } else {
                            poolProceedingItem[i].homeDetailActivityImgUrl = response!!.body()!!.documents[0].image_url!!
                        }

                        if(i==poolProceedingItem.size-1) {

                            if(context == null)
                            {
                                Log.v("Asdf","context is null")
                            }
                            else{
                                homeDetailAdapter = HomeDetailAdapter(context!!, poolProceedingItem, requestManager)
                                homeDetailAdapter!!.setOnItemClickListener(this@PoolTab)
                                v.tab_pool_recyclerview.layoutManager = LinearLayoutManager(v.context)
                                v.tab_pool_recyclerview.adapter = homeDetailAdapter
                            }
                        }

                    } else {
                        Log.v("TAG", "수영장 이미지 검색 값 가져오기 실패")
                    }
                }

                override fun onFailure(call: Call<GetImageSearchResponse>?, t: Throwable?) {
                    Log.v("TAG", "수영장 이미지 서버 통신 실패" + t.toString())
                }

            })
        }


    }

}
