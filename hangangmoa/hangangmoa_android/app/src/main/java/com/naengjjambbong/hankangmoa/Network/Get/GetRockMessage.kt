package com.naengjjambbong.hankangmoa.Network.Get

import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetPoolRowData
import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetRockRowData

data class GetRockMessage (
        var row : ArrayList<GetRockRowData>
)