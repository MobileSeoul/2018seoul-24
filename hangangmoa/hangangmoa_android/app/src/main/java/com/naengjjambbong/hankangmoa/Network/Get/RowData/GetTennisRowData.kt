package com.naengjjambbong.hankangmoa.Network.Get.RowData

data class GetTennisRowData (
        var OBJECTID : Int,
        var FTC : String?,
        var IDN : String?,
        var GIGU : String?,
        var TENAME : String?,
        var TEL : String?,
        var RMK : String?, // 상세 설명
        var X : String?,
        var Y : String?
)