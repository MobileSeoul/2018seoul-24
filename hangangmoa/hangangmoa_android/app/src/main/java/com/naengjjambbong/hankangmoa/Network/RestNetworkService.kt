package com.naengjjambbong.hankangmoa.Network

import com.naengjjambbong.hankangmoa.Network.Get.Response.GetImageSearchResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface RestNetworkService {

    @GET("/v2/search/image")
    fun getImageSearch(
            @Header("Authorization") Authorization: String,
            @Query("query") query : String
    ) : Call<GetImageSearchResponse>

}