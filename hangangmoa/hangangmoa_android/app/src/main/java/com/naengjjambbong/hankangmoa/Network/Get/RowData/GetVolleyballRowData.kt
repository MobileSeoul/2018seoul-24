package com.naengjjambbong.hankangmoa.Network.Get.RowData

data class GetVolleyballRowData (
        var OBJECTID : Int,
        var FTC : String?,
        var IDN : String?,
        var GIGU : String?,
        var VONAME : String?,
        var TEL : String?,
        var RMK : String?, // 상세 설명
        var LAT : String?,
        var LNG : String?
)