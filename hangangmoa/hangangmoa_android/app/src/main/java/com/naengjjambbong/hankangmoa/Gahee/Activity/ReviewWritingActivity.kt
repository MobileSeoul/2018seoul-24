package com.naengjjambbong.hankangmoa.Gahee.Activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.RatingBar
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Gahee.Adapter.MypageSteamListAdapter
import com.naengjjambbong.hankangmoa.Gahee.Item.MypageSteamListItem
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_review_writting.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream


class ReviewWritingActivity : AppCompatActivity() {

    lateinit var mypageSteamListItem: ArrayList<MypageSteamListItem>
    lateinit var mypageSteamListAdapter: MypageSteamListAdapter
    lateinit var requestManager: RequestManager //RequestManger는 이미지 주소를 URL로 가져오면서 사용함

    //lateinit var complete_button : Button
    lateinit var star_rating_bar : RatingBar


    private val REQ_CODE_SELECT_IMAGE = 100
    lateinit var data : Uri
    private var image : MultipartBody.Part? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_writting)

        star_rating_bar = findViewById(R.id.review_write_rating_bar) as RatingBar
        //complete_button = findViewById<>(R.id.)

        review_write_confirm_btn.setOnClickListener{
            var intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)

        }

        fun click(view: View){
            val ratingvalue = star_rating_bar.rating
            //Toast.makeText(this, "Rating is :" + ratingvalue, Toast.LENGTH_LONG.show())
        }

        mypageSteamListItem = ArrayList()
        mypage()
    }

    fun mypage() {
        requestManager = Glide.with(this)//Glide는 뭐야?
        mypageSteamListItem.add(MypageSteamListItem("https://i.pinimg.com/originals/f7/d8/97/f7d8977935a3ef91038141f04e7e759c.png", "한강불꽃축제", "2018.04.02~", "잠실한강공원"))
        mypageSteamListItem.add(MypageSteamListItem("https://i.pinimg.com/originals/f7/d8/97/f7d8977935a3ef91038141f04e7e759c.png", "한강아아축제", "2028.04.02~", "잠실한강공원"))
        mypageSteamListItem.add(MypageSteamListItem("https://i.pinimg.com/originals/f7/d8/97/f7d8977935a3ef91038141f04e7e759c.png", "한강불ㅇ제", "2019.04.02~", "나루원"))
        //projectItems.add(ProjectItem("https://project-cowalker.s3.ap-northeast-2.amazonaws.com/1531113346984.jpg", "ㅁㄴㅇㅎ", "ㅁㄴㅇㄹㄴㅁㅇㅎ", "ㅁㄴㅇㄹ", "ㅇㅎㅁㄴㅇㄹ"))ㅇ
        mypageSteamListAdapter = MypageSteamListAdapter(mypageSteamListItem, requestManager)

        val view = window.decorView

        review_write_add_img.setOnClickListener {
            changeImage()
        }

    }

    fun changeImage(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    //if(ApplicationController.getInstance().is)
                    this.data = data!!.data
                    Log.v("이미지", this.data.toString())

                    val options = BitmapFactory.Options()

                    var input: InputStream? = null // here, you need to get your context.
                    try {
                        input = applicationContext.contentResolver.openInputStream(this.data)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }

                    val bitmap = BitmapFactory.decodeStream(input, null, options) // InputStream 으로부터 Bitmap 을 만들어 준다.
                    val baos = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos)
                    val photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray())
                    val img = File(getRealPathFromURI(applicationContext,this.data).toString()) // 가져온 파일의 이름을 알아내려고 사용합니다

                    Log.v("TAG","이미지 이름 = " + img)
                    Log.v("TAG","이미지 바디 = " + photoBody.toString())


                    image = MultipartBody.Part.createFormData("image", img.name, photoBody)

                    //body = MultipartBody.Part.createFormData("image", photo.getName(), profile_pic);

                    Glide.with(this)
                            .load(data.data)
                            .centerCrop()
                            .into(register_profile_img)

                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

    fun getRealPathFromURI(context: Context, contentUri: Uri): String {
        var cursor: Cursor? = null
        try {
            val proj = arrayOf(MediaStore.Images.Media.DATA)
            cursor = context.contentResolver.query(contentUri, proj, null, null, null)
            val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            return cursor.getString(column_index)
        } finally {
            cursor?.close()
        }
    }
}
