package com.naengjjambbong.hankangmoa.Network

import com.naengjjambbong.hankangmoa.Network.Get.Response.GetImageSearchResponse
import com.naengjjambbong.hankangmoa.Network.Get.Response.GetWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SKPlanetNetworkService {

    @GET("/weather/current/minutely")
    fun getWeatherData(
            @Header("appKey") appKey: String,
            @Query("version") version : String,
            @Query("lat") lat : String,
            @Query("lon") lon : String,
            @Query("city") city : String,
            @Query("county") county : String,
            @Query("village") village : String,
            @Query("stnid") stnid : String
    ) : Call<GetWeatherResponse>

}