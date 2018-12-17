package com.naengjjambbong.hankangmoa.Jemin.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.naengjjambbong.hankangmoa.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setContentView(R.layout.activity_splash)

        val hd = Handler()
        hd.postDelayed(splashhandler(), 3000) // 3000ms=3초후에 핸들러 실행 //딜레이 3000

    }

    private inner class splashhandler : Runnable {
        override fun run() {
            startActivity(Intent(application, LoginActivity::class.java))
            //startActivity(new Intent(getApplication(), UserSelectActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out) // fade in, fade out 애니메이션 효과

            this@SplashActivity.finish() // 스플래쉬 페이지 액티비티 스택에서 제거
        }
    }

    override fun onBackPressed() {
        //스플래쉬 화면에서 뒤로가기 버튼 금지
    }




}
