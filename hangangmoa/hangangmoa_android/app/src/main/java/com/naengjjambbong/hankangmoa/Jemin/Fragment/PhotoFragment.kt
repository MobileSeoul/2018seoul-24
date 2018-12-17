package com.naengjjambbong.hankangmoa.Jemin.Fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Jemin.Adapter.PhotoCategoryAdapter
import com.naengjjambbong.hankangmoa.Jemin.Item.PhotoCategoryItem
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.fragment_photo.*
import kotlinx.android.synthetic.main.fragment_photo.view.*

class PhotoFragment : Fragment(), View.OnClickListener {

    var cateGoryItem = ArrayList<PhotoCategoryItem>()
    lateinit var photoCategoryAdapter: PhotoCategoryAdapter
    lateinit var requestManager: RequestManager

    override fun onClick(v: View?) {
        when(v)
        {
            photo_linear_view_layout -> {
                photo_linear_view_layout.isSelected = true
                photo_grid_view_layout.isSelected = false
                replaceFragment(LinearPhotoFragment())
            }

            photo_grid_view_layout -> {
                photo_grid_view_layout.isSelected = true
                photo_linear_view_layout.isSelected = false
                replaceFragment(GridPhotoFragment())
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_photo, container, false)
        // Inflate the layout for this fragmen
        requestManager = Glide.with(this)

        v.photo_linear_view_layout.setOnClickListener(this)
        v.photo_grid_view_layout.setOnClickListener(this)

        v.photo_linear_view_layout.isSelected = true

        addFragment(LinearPhotoFragment())

        getCategoryList(v)


        val region_list = arrayOf("지역 선택", "여의도 한강공원", "뚝섬 한강공원", "반포 한강공원", "잠실 한강공원", "망원 한강공원", "기타")
        val category_list = arrayOf("카테고리 선택", "음악/콘서트", "캠핑", "스포츠", "꽃놀이", "체험", "물놀이", "문화/전시", "기타")


        val regionSpinner = v.findViewById<View>(R.id.photo_region_spinner) as Spinner
        val categorySpinner = v.findViewById<View>(R.id.photo_category_spinner) as Spinner

        // 지역에 대한 Spinner
        val adapter = ArrayAdapter(
                activity, // 현재화면의 제어권자
                R.layout.spin,
                region_list)
        adapter.setDropDownViewResource(
                R.layout.spin_dropdown)
        regionSpinner.adapter = adapter

        // 카테고리에 대한 Spinner
        val adapter2 = ArrayAdapter(
                activity, // 현재화면의 제어권자
                R.layout.spin,
                category_list)
        adapter2.setDropDownViewResource(
                R.layout.spin_dropdown)
        categorySpinner.adapter = adapter2

        regionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position == 0) {

                } else if (position == 1) {

                } else if (position == 2) {

                } else if (position == 3) {

                } else if (position == 4) {

                } else if (position == 5) {

                } else if (position == 6){

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position == 0) {

                } else if (position == 1) {

                } else if (position == 2) {

                } else if (position == 3) {

                } else if (position == 4) {

                } else if (position == 5) {

                } else if(position == 6) {

                } else if(position == 7){

                } else if(position == 8){

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        return v
    }

    fun addFragment(fragment : Fragment){
        val fm = childFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.photo_content_layout, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment)
    {
        val fm = childFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.photo_content_layout, fragment)
//        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun getCategoryList(v: View){

        cateGoryItem.add(PhotoCategoryItem("https://post-phinf.pstatic.net/MjAxNzAyMTNfMTE4/MDAxNDg2OTYwMjg2NDM1.6MjxIxSbfUTmmKdbaMVnKkp5c4Vm71nCO60rGWAU6cIg.Q2yYzJerPnZFp9Z7Ci2eN6IKTN1n_t9FFqDKT1PQ-SUg.JPEG/GettyImages-471837692.jpg?type=w1200", "여의도 한강공원"))
        cateGoryItem.add(PhotoCategoryItem("http://www.lafentgarden.com/mono/data/news/img1/5794.jpg", "뚝섬 한강공원"))
        cateGoryItem.add(PhotoCategoryItem("http://img.hankyung.com/photo/200904/2009042781711_2009042835221.jpg", "반포 한강공원"))
        cateGoryItem.add(PhotoCategoryItem("http://mblogthumb2.phinf.naver.net/MjAxNzA0MDRfNzIg/MDAxNDkxMjkxOTkyNzYx.xZkeSCUeBSGMR4hfKRSAlQJ_CAu5DMK7xBKtU9uDpIwg.2EbUVpV9La4nwklNaJnuHFl46G-mI_yJa_qAu0wQ6Twg.JPEG.pobain/cm26010039.jpg?type=w2", "잠실 한강공원"))
        cateGoryItem.add(PhotoCategoryItem("http://seoulstory.kr/namoeditor/binary/images/000088/%EB%A7%9D%EC%9B%90%ED%95%9C%EA%B0%95.png", "망원 한강공원"))

        photoCategoryAdapter = PhotoCategoryAdapter(cateGoryItem, requestManager)
        v.photo_category_list_recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        v.photo_category_list_recyclerview.adapter = photoCategoryAdapter
    }
}