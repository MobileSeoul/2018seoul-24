package com.naengjjambbong.hankangmoa.Jemin.Fragment.CategoryTab

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Jemin.Adapter.HomeDetailAdapter
import com.naengjjambbong.hankangmoa.Jemin.Fragment.CategoryTab.SportCategory.*
import com.naengjjambbong.hankangmoa.Jemin.Item.MongDDangItem
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetPoolResponse
import com.naengjjambbong.hankangmoa.Network.RestNetworkService
import com.naengjjambbong.hankangmoa.Network.SeoulApiController
import com.naengjjambbong.hankangmoa.Network.SeoulNetworkService
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.fragment_activitytab.view.*
import kotlinx.android.synthetic.main.fragment_sporttab.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SportTab : Fragment() {
    lateinit var seoulNetworkService : SeoulNetworkService
    lateinit var restNetworkService : RestNetworkService

    lateinit var homeDetailAdapter : HomeDetailAdapter
    lateinit var requestManager: RequestManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_sporttab, container, false)//지도

        requestManager = Glide.with(this)
        v.tab_sport_badminton_btn.isSelected = true
        v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#ffffff"))
        addFragment(BadmintonTab())

        v.tab_sport_badminton_btn.setOnClickListener {
            replaceFragment(BadmintonTab())
            v.tab_sport_badminton_btn.isSelected = true
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))
        }
        v.tab_sport_ronbowling_btn.setOnClickListener {
            v.tab_sport_ronbowling_btn.isSelected = true
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))
            replaceFragment(BowllingTab())
        }
        v.tab_sport_rockclimbing_btn.setOnClickListener {
            v.tab_sport_rockclimbing_btn.isSelected = true
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))

            replaceFragment(RockTab())
        }
        v.tab_sport_water_btn.setOnClickListener {
            v.tab_sport_water_btn.isSelected = true
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))
            replaceFragment(WaterTab())
        }
        v.tab_sport_inline_btn.setOnClickListener {
            v.tab_sport_inline_btn.isSelected = true
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))
            replaceFragment(InlineTab())
        }
        v.tab_sport_jokgu_btn.setOnClickListener {
            v.tab_sport_jokgu_btn.isSelected = true
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))
            replaceFragment(JokguTab())
        }
        v.tab_sport_woodball_btn.setOnClickListener {
            v.tab_sport_woodball_btn.isSelected = true
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))
            replaceFragment(WoodballTab())
        }
        v.tab_sport_golf_btn.setOnClickListener {
            v.tab_sport_golf_btn.isSelected = true
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))
            replaceFragment(GolfTab())
        }
        v.tab_sport_basketball_btn.setOnClickListener {
            v.tab_sport_basketball_btn.isSelected = true
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))
            replaceFragment(BasketballTab())
        }
        v.tab_sport_volleyball_btn.setOnClickListener {
            v.tab_sport_volleyball_btn.isSelected = true
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))
            replaceFragment(VolleyballTab())
        }
        v.tab_sport_tennis_btn.setOnClickListener {
            v.tab_sport_tennis_btn.isSelected = true
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_soccer_btn.isSelected = false
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#000000"))
            replaceFragment(TennisTab())
        }
        v.tab_sport_soccer_btn.setOnClickListener {
            v.tab_sport_soccer_btn.isSelected = true
            v.tab_sport_soccer_btn.setTextColor(Color.parseColor("#ffffff"))

            v.tab_sport_badminton_btn.isSelected = false
            v.tab_sport_badminton_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_ronbowling_btn.isSelected = false
            v.tab_sport_ronbowling_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_water_btn.isSelected = false
            v.tab_sport_water_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_inline_btn.isSelected = false
            v.tab_sport_inline_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_jokgu_btn.isSelected = false
            v.tab_sport_jokgu_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_woodball_btn.isSelected = false
            v.tab_sport_woodball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_golf_btn.isSelected = false
            v.tab_sport_golf_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_basketball_btn.isSelected = false
            v.tab_sport_basketball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_volleyball_btn.isSelected = false
            v.tab_sport_volleyball_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_tennis_btn.isSelected = false
            v.tab_sport_tennis_btn.setTextColor(Color.parseColor("#000000"))
            v.tab_sport_rockclimbing_btn.isSelected = false
            v.tab_sport_rockclimbing_btn.setTextColor(Color.parseColor("#000000"))
            replaceFragment(SoccerTab())
        }

        return v
    }

    fun addFragment(fragment : Fragment){
        val fm = childFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.sport_content_layout, fragment)

        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment)
    {
        val fm = childFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.sport_content_layout, fragment)
//        transaction.addToBackStack(null)
        transaction.commit()
    }
}

