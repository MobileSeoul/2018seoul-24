package com.naengjjambbong.hankangmoa.Network.Get

import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetBadmintonRowData
import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetSoccerRowData

data class GetBadmintonMessage (
        var row : ArrayList<GetBadmintonRowData>
)