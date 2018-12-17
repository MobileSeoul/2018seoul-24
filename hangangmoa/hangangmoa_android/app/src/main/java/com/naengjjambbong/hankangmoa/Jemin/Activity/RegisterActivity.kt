package com.naengjjambbong.hankangmoa.Jemin.Activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.Network.ApplicationController
import com.naengjjambbong.hankangmoa.Network.Item.PostRegister
import com.naengjjambbong.hankangmoa.Network.NetworkService
import com.naengjjambbong.hankangmoa.Network.Post.PostProfileImageResponse
import com.naengjjambbong.hankangmoa.Network.Post.PostRegisterResponse
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream

class RegisterActivity : AppCompatActivity() {

    private val REQ_CODE_SELECT_IMAGE = 100
    lateinit var data : Uri
    private var file : MultipartBody.Part? = null
    lateinit var requestManager: RequestManager
    lateinit var networkService : NetworkService

    var email : String = ""
    var pw : String = ""
    var name : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val view = window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                // 23 버전 이상일 때 상태바 하얀 색상에 회색 아이콘 색상을 설정
                view.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.statusBarColor = Color.parseColor("#FFFFFF")
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            window.statusBarColor = Color.BLACK
        }

        register_confirm_btn.setOnClickListener {
            postRegister()

        }

        register_profile_img.setOnClickListener {
            changeImage()
        }

        register_change_photo_btn.setOnClickListener {
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
                    val image = File(getRealPathFromURI(applicationContext,this.data).toString()) // 가져온 파일의 이름을 알아내려고 사용합니다

                    Log.v("TAG","이미지 이름 = " + image)
                    Log.v("TAG","이미지 바디 = " + photoBody.toString())


                    file = MultipartBody.Part.createFormData("image", image.name, photoBody)

                    //body = MultipartBody.Part.createFormData("image", photo.getName(), profile_pic);
                    postProfileImage()

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

    fun postRegister()
    {
        email = register_email_edit.text.toString()
        name = register_name_edit.text.toString()
        pw = register_passwd_edit.text.toString()

        networkService = ApplicationController.getRetrofit().create(NetworkService::class.java)
        var postRegister = PostRegister(email, pw, name)
        var postRegisterResponse = networkService.postRegister(postRegister)
        Log.v("TAG", "회원가입 생성 통신 전")
        postRegisterResponse.enqueue(object : retrofit2.Callback<PostRegisterResponse>{

            override fun onResponse(call: Call<PostRegisterResponse>, response: Response<PostRegisterResponse>) {
                Log.v("TAG", "회원가입 생성 통신 성공")
                if(response.isSuccessful){
                    Log.v("TAG", "회원가입 성공")
                    var intent = Intent(applicationContext, LoginActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<PostRegisterResponse>, t: Throwable?) {
                Toast.makeText(applicationContext,"회원가입 서버 연결 실패", Toast.LENGTH_SHORT).show()
            }
        })

    }

    fun postProfileImage() {
        networkService = ApplicationController.getRetrofit().create(NetworkService::class.java)

        val idx = RequestBody.create(MediaType.parse("text.plain"), "1")

      //  file =register_profile_img.

        val postProfileImageResponse = networkService.postProfileImage(idx, file)

        postProfileImageResponse.enqueue(object : retrofit2.Callback<PostProfileImageResponse>{

            override fun onResponse(call: Call<PostProfileImageResponse>, response: Response<PostProfileImageResponse>) {
                if(response.isSuccessful){
                    var message = response!!.body()

                    Log.v("TAG", "프로필이미지 삽입 전달 성공"+ message.toString())
                }
                else{

                    Log.v("TAG", "프로필이미지 삽입 값 전달 실패"+ response!!.body().toString())
                }
            }

            override fun onFailure(call: Call<PostProfileImageResponse>, t: Throwable?) {
                Toast.makeText(applicationContext,"프로필이미지 삽입 서버 연결 실패", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
