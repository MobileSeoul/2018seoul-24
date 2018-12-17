package com.naengjjambbong.hankangmoa.Jemin.Fragment

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Activity.DetailActivity
import com.naengjjambbong.hankangmoa.Jemin.Activity.MainActivity
import com.naengjjambbong.hankangmoa.Jemin.Adapter.HomeDetailAdapter
import com.naengjjambbong.hankangmoa.Jemin.Fragment.CategoryTab.ActivityTab
import com.naengjjambbong.hankangmoa.Jemin.Fragment.CategoryTab.CampingTab
import com.naengjjambbong.hankangmoa.Jemin.Fragment.CategoryTab.PoolTab
import com.naengjjambbong.hankangmoa.Jemin.Fragment.CategoryTab.SportTab
import com.naengjjambbong.hankangmoa.Jemin.Item.HomeDetailItem
import com.naengjjambbong.hankangmoa.Jemin.Item.MongDDangItem
import com.naengjjambbong.hankangmoa.Network.Get.GetCampingMessage
import com.naengjjambbong.hankangmoa.Network.Get.GetMongDDangMesssage
import com.naengjjambbong.hankangmoa.Network.Get.GetPoolMessage
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetCampingResponse
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetImageSearchResponse
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetMongDDangResponse
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetPoolResponse
import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetPoolRowData
import com.naengjjambbong.hankangmoa.Network.RestApplicationController
import com.naengjjambbong.hankangmoa.Network.RestNetworkService
import com.naengjjambbong.hankangmoa.Network.SeoulApiController
import com.naengjjambbong.hankangmoa.Network.SeoulNetworkService
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.fragment_home_detail.*
import kotlinx.android.synthetic.main.fragment_home_detail.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class HomeDetailFragment : Fragment(), MainActivity.OnBackPressedListener{

    lateinit var seoulNetworkService : SeoulNetworkService
    lateinit var restNetworkService : RestNetworkService

    var categoryNumber : Int = 0

    var homeDetailItem = ArrayList<HomeDetailItem>()
    var mongDDangItem = ArrayList<MongDDangItem>()

    var selectedCategoryNum : Int = 0

    var mainFragment = HomeFragment()
    override fun onBack() {
        Log.e("Other", "onBack()")
        // 리스너를 설정하기 위해 Activity 를 받아옵니다.
        //val activity = activity as MainActivity?
        // 한번 뒤로가기 버튼을 눌렀다면 Listener 를 null 로 해제해줍니다.
        MainActivity.mainActivity.setOnBackPressedListener(null)
        // MainFragment 로 교체
        HomeMainFragment.homeMainFragment.replaceFragment(mainFragment)
        // Activity 에서도 뭔가 처리하고 싶은 내용이 있다면 하단 문장처럼 호출해주면 됩니다.
        // activity.onBackPressed();
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_home_detail, container, false)
        // Inflate the layout for this fragmen

        categoryNumber=4

        val category_list = arrayOf("문화/행사", "캠핑", "스포츠", "물놀이")
        val sort_list = arrayOf("최신순", "인기순")

        val categorySpinner = v.findViewById<View>(R.id.home_detail_category_spinner) as Spinner
        val sortSpinner = v.findViewById<View>(R.id.home_detail_sort_spinner) as Spinner

        // 카테고리에 대한 Spinner
        val adapter = ArrayAdapter(
                activity, // 현재화면의 제어권자
                R.layout.spin,
                category_list)
        adapter.setDropDownViewResource(
                R.layout.spin_dropdown)
        categorySpinner.adapter = adapter

        // 정렬에 대한 Spinner
        val adapter2 = ArrayAdapter(
                activity, // 현재화면의 제어권자
                R.layout.spin,
                sort_list)
        adapter2.setDropDownViewResource(
                R.layout.spin_dropdown)
        sortSpinner.adapter = adapter2

        selectedCategoryNum = HomeFragment.homeFragment.selectedCategoryNum
        categorySpinner.setSelection(selectedCategoryNum)
        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position == 0) {
                    Log.v("asdf", "문화/행사 호출")
                    replaceFragment(ActivityTab())
                } else if (position == 1) {
                    replaceFragment(CampingTab())
                } else if (position == 2) {
                    Log.v("Asdf", "캠핑장 호출")
                    replaceFragment(SportTab())
                } else if (position == 3) {
                    replaceFragment(PoolTab())
                } else if (position == 4) {

                } else {
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        sortSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position == 0) {
                } else {

                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
        //getMongDDangList(v)
        addFragment(ActivityTab())

        return v
    }

    // Fragment 호출 시 반드시 호출되는 오버라이드 메소드입니다.
    // 혹시 Context 로 안되시는분은 Activity 로 바꿔보시기 바랍니다.
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("Other", "onAttach()")
        (context as MainActivity).setOnBackPressedListener(this)
    }

    fun addFragment(fragment : Fragment){
        val fm = childFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.home_detail_content_layout, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment)
    {
        val fm = childFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.home_detail_content_layout, fragment)
//        transaction.addToBackStack(null)
        transaction.commit()
    }
}
