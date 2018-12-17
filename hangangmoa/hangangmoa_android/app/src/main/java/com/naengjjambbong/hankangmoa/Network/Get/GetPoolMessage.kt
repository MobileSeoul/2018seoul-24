package com.naengjjambbong.hankangmoa.Network.Get

import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetPoolRowData

data class GetPoolMessage (
        var row : ArrayList<GetPoolRowData>
)