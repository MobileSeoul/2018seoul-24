package com.naengjjambbong.hankangmoa.Network

import com.naengjjambbong.hankangmoa.Network.Get.Response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SeoulNetworkService {

    @GET("/{key}/json/Mgishangang/{page_no}/71/")
    fun getMongDDangList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetMongDDangResponse>

    @GET("/{key}/json/SebcCampingInfoKor/1/{page_no}/")
    fun getCampingList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetCampingResponse>

    @GET("/{key}/json/GeoInfoPool/1/{page_no}/")
    fun getPoolList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetPoolResponse>

    @GET("/{key}/json/GeoInfoSoccerWGS/1/{page_no}/")
    fun getSoccerList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetSoccerResponse>

    @GET("/{key}/json/GeoInfoJokguWGS/1/{page_no}/")
    fun getJokguList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetJokguResponse>

    @GET("/{key}/json/GeoInfoBasketball/1/{page_no}/")
    fun getBasketballList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetBasketballResponse>

    @GET("/{key}/json/GeoInfoTennis/1/{page_no}/")
    fun getTennisList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetTennisResponse>

    @GET("/{key}/json/GeoInfoBadmintonWGS/1/{page_no}/")
    fun getBadmintonList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetBadmintonResponse>

    @GET("/{key}/json/GeoInfoParkGolfWGS/1/{page_no}/")
    fun getGolfList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetGolfResponse>

    @GET("/{key}/json/GeoInfoInlineSkateWGS/1/{page_no}/")
    fun getInlineList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetInlineResponse>

    @GET("/{key}/json/GeoInfoRockClimbWGS/1/{page_no}/")
    fun getRockList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetRockResponse>

    @GET("/{key}/json/GeoInfoWoodball/1/{page_no}/")
    fun getWoodBallList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetWoodballResponse>

    @GET("/{key}/json/GeoInfoWaterLeisureWGS/1/{page_no}/")
    fun getWaterList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetWaterResponse>

    @GET("/{key}/json/GeoInfoVolleyballWGS/1/{page_no}/")
    fun getVolleyballList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetVolleyballResponse>

    @GET("/{key}/json/GeoInfoLawnBowlingWGS/1/{page_no}/")
    fun getBowllingList(
            @Path("key") key : String,
            @Path("page_no") pageNo : Int
    ) : Call<GetBowllingResponse>





}