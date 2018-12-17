package com.naengjjambbong.hankangmoa.Jemin.Fragment

import android.content.Intent
import android.view.ViewGroup
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.naengjjambbong.hankangmoa.Jemin.Activity.MainActivity
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.fragment_map.view.*
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView


class MapFragment : Fragment() {

    var searchFlag : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_map, container, false)//지도
        val mapView = MapView(activity)
        val mapViewContainer = v.findViewById(R.id.map_view) as ViewGroup
        mapViewContainer.addView(mapView)

        // 중심점 변경 - 예제 좌표는 서울 남산
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.54892296550104, 126.99089033876304), true)

        // 줌 레벨 변경
        mapView.setZoomLevel(4, true)

        //마커 찍기
        val MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.54892296550104, 126.99089033876304)
        val marker = MapPOIItem()
        marker.itemName = "Default Marker"
        marker.tag = 0
        marker.mapPoint = MARKER_POINT
        marker.markerType = MapPOIItem.MarkerType.BluePin // 기본으로 제공하는 BluePin 마커 모양.
        marker.selectedMarkerType = MapPOIItem.MarkerType.RedPin // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView.addPOIItem(marker)

        v.map_search_edit.visibility = View.GONE

        v.map_gps_btn.setOnClickListener {
            var intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        v.map_search_btn.setOnClickListener {
            if(searchFlag == 0)
            {
                v.map_title_tv.visibility = View.GONE
                v.map_search_edit.visibility = View.VISIBLE
                //searchFlag = 1
            }
            else if(searchFlag == 1){
                v.map_title_tv.visibility = View.VISIBLE
                v.map_search_edit.visibility = View.GONE
                searchFlag = 0
            }

        }

        v.map_search_edit.setOnClickListener {

        }

        return v
    }
}