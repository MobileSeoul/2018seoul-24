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
import com.naengjjambbong.hankangmoa.Jemin.Item.CampingItem
import com.naengjjambbong.hankangmoa.Jemin.Item.MongDDangItem
import com.naengjjambbong.hankangmoa.Network.Get.GetCampingMessage
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetCampingResponse
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetImageSearchResponse
import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetCampingRowData
import com.naengjjambbong.hankangmoa.Network.RestApplicationController
import com.naengjjambbong.hankangmoa.Network.RestNetworkService
import com.naengjjambbong.hankangmoa.Network.SeoulApiController
import com.naengjjambbong.hankangmoa.Network.SeoulNetworkService
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.fragment_campingtab.*
import kotlinx.android.synthetic.main.fragment_campingtab.view.*
import kotlinx.android.synthetic.main.fragment_pooltab.view.*
import kotlinx.android.synthetic.main.fragment_sport.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class CampingTab : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        val idx : Int = tab_camping_recyclerview.getChildAdapterPosition(v)
        Log.v("TAG","클릭이벤트 감지 포지션 = " + idx)

        val intent = Intent(getActivity(), DetailActivity::class.java)
        startActivity(intent)
    }

    lateinit var seoulNetworkService : SeoulNetworkService
    lateinit var restNetworkService : RestNetworkService

    lateinit var homeDetailAdapter : HomeDetailAdapter
    lateinit var requestManager: RequestManager

    // 캠핑장 데이터
    lateinit var campingRow : GetCampingMessage
    lateinit var campingData : ArrayList<GetCampingRowData>

    var campingProceedingItem = ArrayList<MongDDangItem>()
    var campingCompletedItem = ArrayList<MongDDangItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_campingtab, container, false)//지도

        requestManager = Glide.with(this)
        getCampingList(v)

        v.camping_proceeding_btn.isSelected = true
        v.camping_proceeding_btn.setTextColor(Color.parseColor("#ffffff"))

        v.camping_proceeding_btn.setOnClickListener {

            v.camping_proceeding_btn.isSelected = true
            v.camping_proceeding_btn.setTextColor(Color.parseColor("#ffffff"))
            v.camping_stop_btn.isSelected = false
            v.camping_stop_btn.setTextColor(Color.parseColor("#000000"))

            homeDetailAdapter = HomeDetailAdapter(context!!, campingProceedingItem, requestManager)
            homeDetailAdapter.setOnItemClickListener(this@CampingTab)
            v.tab_camping_recyclerview.layoutManager = LinearLayoutManager(v.context)
            v.tab_camping_recyclerview.adapter = homeDetailAdapter
        }

        v.camping_stop_btn.setOnClickListener {

            v.camping_stop_btn.isSelected = true
            v.camping_stop_btn.setTextColor(Color.parseColor("#ffffff"))
            v.camping_proceeding_btn.isSelected = false
            v.camping_proceeding_btn.setTextColor(Color.parseColor("#000000"))
            homeDetailAdapter = HomeDetailAdapter(context!!, campingCompletedItem, requestManager)
            homeDetailAdapter.setOnItemClickListener(this@CampingTab)
            v.tab_camping_recyclerview.layoutManager = LinearLayoutManager(v.context)
            v.tab_camping_recyclerview.adapter = homeDetailAdapter
        }

        return v
    }

    private fun getCampingList(v : View) {

        var key : String = "4d43676e45777061313130726e6a414d"

        var pageNo = 14
        try {
            seoulNetworkService = SeoulApiController.getRetrofit().create(SeoulNetworkService::class.java)
            var getCampingResponse = seoulNetworkService.getCampingList(key, pageNo) // 네트워크 서비스의 getContent 함수를 받아옴
            Log.v("TAG","서울시 캠핑장 데이터 GET 통신 시작 전")
            getCampingResponse.enqueue(object : Callback<GetCampingResponse> {
                override fun onResponse(call: Call<GetCampingResponse>?, response: Response<GetCampingResponse>?) {
                    if(response!!.isSuccessful) {
                        Log.v("TAG","서울시 캠핑장 데이터 GET 통신 성공")
                        campingRow = response!!.body()!!.SebcCampingInfoKor

                        campingData = campingRow!!.row
                        if(campingRow!!.row.size == 0)
                        {
                            Log.v("TAG","서울시 캠핑장 데이터 값 없음.")
                        }
                        else
                        {
                            for(i in 0..campingData.size-1) {
                                Log.v("asdf", "캠핑장 데이터 [" + i + "] = " + campingData[i].NAME_KOR)
                                if(campingData[i].OPER_HOUR == ""){
                                    campingProceedingItem.add(MongDDangItem(campingData[i].NAME_KOR, campingData[i].OPER_HOUR, "null"))

                                }
                                else{
                                    campingCompletedItem.add(MongDDangItem(campingData[i].NAME_KOR, campingData[i].OPER_HOUR, "null"))

                                }
                            }
                            imageSearch(v,1)
                            imageSearch(v,0)
                        }
                    }
                }

                override fun onFailure(call: Call<GetCampingResponse>?, t: Throwable?) {
                    Log.v("TAG","서울시 캠핑장 데이터 통신 실패" + t.toString())
                }
            })
        } catch (e: Exception) {
        }

    }

    fun imageSearch(v : View, statusFlag : Int) {

        restNetworkService = RestApplicationController.getRetrofit().create(RestNetworkService::class.java)
        Log.v("ASdf", "수영장 이미지 데이터 가져오기 시작")
        if (statusFlag == 1) {
            for (i in 0..campingProceedingItem.size - 1) {
                Log.v("TAG", "수영장 이미지 검색 통신 시작 전 = " + i)

                var getImageSearchResponse = restNetworkService.getImageSearch("KakaoAK 298be2e3612229355b9d2e28bb10912e", campingProceedingItem[i].homeDetailActivityName!!)

                getImageSearchResponse.enqueue(object : Callback<GetImageSearchResponse> {
                    override fun onResponse(call: Call<GetImageSearchResponse>?, response: Response<GetImageSearchResponse>?) {
                        Log.v("TAG", "수영장 이미지 검색 통신 시작")
                        if (response!!.isSuccessful) {

                            Log.v("TAG", "수영장 이미지 검색 통신 성공")

                            if (response!!.body()!!.documents!!.size == 0) {
                                campingProceedingItem[i].homeDetailActivityImgUrl = "https://2.bp.blogspot.com/-a7VX4tT-g4k/WdEZ8eaDrWI/AAAAAAAC-mA/O5cw44tb1TMA7gJzhvnX8b1ObO0y80-tACLcBGAs/s1600/%25ED%2595%259C%25EA%25B0%2595%2B%25EA%25B8%25B8%25EC%259D%25B4.jpg"
                            } else {
                                campingProceedingItem[i].homeDetailActivityImgUrl = response!!.body()!!.documents[0].image_url!!
                            }

                            if (i == campingProceedingItem.size - 1) {

                                if (context == null) {
                                    Log.v("Asdf", "context is null")
                                } else {
                                    homeDetailAdapter = HomeDetailAdapter(context!!, campingProceedingItem, requestManager)
                                    homeDetailAdapter!!.setOnItemClickListener(this@CampingTab)
                                    v.tab_camping_recyclerview.layoutManager = LinearLayoutManager(v.context)
                                    v.tab_camping_recyclerview.adapter = homeDetailAdapter
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
        } else if (statusFlag == 0) {
            for (i in 0..campingCompletedItem.size - 1) {
                Log.v("TAG", "수영장 이미지 검색 통신 시작 전 = " + i)

                var getImageSearchResponse = restNetworkService.getImageSearch("KakaoAK 298be2e3612229355b9d2e28bb10912e", campingCompletedItem[i].homeDetailActivityName!!)

                getImageSearchResponse.enqueue(object : Callback<GetImageSearchResponse> {
                    override fun onResponse(call: Call<GetImageSearchResponse>?, response: Response<GetImageSearchResponse>?) {
                        Log.v("TAG", "수영장 이미지 검색 통신 시작")
                        if (response!!.isSuccessful) {

                            Log.v("TAG", "수영장 이미지 검색 통신 성공")

                            if (response!!.body()!!.documents!!.size == 0) {
                                campingCompletedItem[i].homeDetailActivityImgUrl = "https://2.bp.blogspot.com/-a7VX4tT-g4k/WdEZ8eaDrWI/AAAAAAAC-mA/O5cw44tb1TMA7gJzhvnX8b1ObO0y80-tACLcBGAs/s1600/%25ED%2595%259C%25EA%25B0%2595%2B%25EA%25B8%25B8%25EC%259D%25B4.jpg"
                            } else {
                                campingCompletedItem[i].homeDetailActivityImgUrl = response!!.body()!!.documents[0].image_url!!
                            }

                            if (i == campingCompletedItem.size - 1) {

                                if (context == null) {
                                    Log.v("Asdf", "context is null")
                                } else {
                                    homeDetailAdapter = HomeDetailAdapter(context!!, campingCompletedItem, requestManager)
                                    homeDetailAdapter!!.setOnItemClickListener(this@CampingTab)
                                    v.tab_camping_recyclerview.layoutManager = LinearLayoutManager(v.context)
                                    v.tab_camping_recyclerview.adapter = homeDetailAdapter
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

}