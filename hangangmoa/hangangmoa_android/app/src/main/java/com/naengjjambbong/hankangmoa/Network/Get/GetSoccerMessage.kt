package com.naengjjambbong.hankangmoa.Network.Get

import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetPoolRowData
import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetSoccerRowData

data class GetSoccerMessage (
        var row : ArrayList<GetSoccerRowData>
)