package com.naengjjambbong.hankangmoa.Network.Get

import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetWeatherData

data class GetWeatherMessage (
      var minutely : ArrayList<GetWeatherData>
)