package com.naengjjambbong.hankangmoa.Jemin.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Jemin.Adapter.GridPhotoAdapter
import com.naengjjambbong.hankangmoa.Jemin.Adapter.PhotoCategoryAdapter
import com.naengjjambbong.hankangmoa.Jemin.Item.GridPhotoItem
import com.naengjjambbong.hankangmoa.Jemin.Item.PhotoCategoryItem
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.fragment_photo.view.*
import kotlinx.android.synthetic.main.fragment_photo_grid.view.*

class GridPhotoFragment : Fragment() {

    var gridListItem = ArrayList<GridPhotoItem>()
    lateinit var gridPhotoAdapter : GridPhotoAdapter
    lateinit var requestManager: RequestManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_photo_grid, container, false)
        // Inflate the layout for this fragmen
        requestManager = Glide.with(this)

        getGridList(v)

        return v
    }

    fun getGridList(v: View){

        gridListItem.add(GridPhotoItem("http://1.bp.blogspot.com/-VYe_dHtxbGs/VZeB38JpOFI/AAAAAAAAIHM/ZEUxv5jP7Ng/s1600/654A1500.jpg", "양화대교", "송제민"))
        gridListItem.add(GridPhotoItem("http://1.bp.blogspot.com/-VYe_dHtxbGs/VZeB38JpOFI/AAAAAAAAIHM/ZEUxv5jP7Ng/s1600/654A1500.jpg", "양화대교", "송제민"))
        gridListItem.add(GridPhotoItem("http://1.bp.blogspot.com/-VYe_dHtxbGs/VZeB38JpOFI/AAAAAAAAIHM/ZEUxv5jP7Ng/s1600/654A1500.jpg", "양화대교", "송제민"))
        gridListItem.add(GridPhotoItem("http://1.bp.blogspot.com/-VYe_dHtxbGs/VZeB38JpOFI/AAAAAAAAIHM/ZEUxv5jP7Ng/s1600/654A1500.jpg", "양화대교", "송제민"))
        gridListItem.add(GridPhotoItem("http://1.bp.blogspot.com/-VYe_dHtxbGs/VZeB38JpOFI/AAAAAAAAIHM/ZEUxv5jP7Ng/s1600/654A1500.jpg", "양화대교", "송제민"))
        gridListItem.add(GridPhotoItem("http://1.bp.blogspot.com/-VYe_dHtxbGs/VZeB38JpOFI/AAAAAAAAIHM/ZEUxv5jP7Ng/s1600/654A1500.jpg", "양화대교", "송제민"))
        gridListItem.add(GridPhotoItem("http://1.bp.blogspot.com/-VYe_dHtxbGs/VZeB38JpOFI/AAAAAAAAIHM/ZEUxv5jP7Ng/s1600/654A1500.jpg", "양화대교", "송제민"))
        gridListItem.add(GridPhotoItem("http://1.bp.blogspot.com/-VYe_dHtxbGs/VZeB38JpOFI/AAAAAAAAIHM/ZEUxv5jP7Ng/s1600/654A1500.jpg", "양화대교", "송제민"))

        gridPhotoAdapter = GridPhotoAdapter(gridListItem, requestManager)
        v.grid_photo_recyclerview.layoutManager = GridLayoutManager(v.context, 2)
        v.grid_photo_recyclerview.adapter = gridPhotoAdapter
    }
}