package com.naengjjambbong.hankangmoa.Network.Get

import com.naengjjambbong.hankangmoa.Network.Get.RowData.GetBasketballRowData

data class GetBasketballMessage (
        var row : ArrayList<GetBasketballRowData>
)