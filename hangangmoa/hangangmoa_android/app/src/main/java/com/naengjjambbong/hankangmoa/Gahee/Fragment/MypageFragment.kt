package com.naengjjambbong.hankangmoa.Gahee.Fragment

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.naengjjambbong.hankangmoa.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_mypage.*
import kotlinx.android.synthetic.main.fragment_mypage.view.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream

class MypageFragment :  Fragment(), View.OnClickListener {

    lateinit var requestManager: RequestManager

    private val REQ_CODE_SELECT_IMAGE = 100
    lateinit var data: Uri
    private var image: MultipartBody.Part? = null


    override fun onClick(v: View?) {

        when (v) {
            mypage_steamlist_tv -> {
                mypage_steamlist_tv.isSelected = true
                mypage_myreview_tv.isSelected = false
                replaceFragment(MypageSteamListFragment())

                fragment_mypage_view1.visibility = View.VISIBLE
                fragment_mypage_view2.visibility = View.GONE
            }

            mypage_myreview_tv -> {
                mypage_myreview_tv.isSelected = true
                mypage_steamlist_tv.isSelected = false
                replaceFragment(MypageMyreviewFragment())

                fragment_mypage_view2.visibility = View.VISIBLE
                fragment_mypage_view1.visibility = View.GONE
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_mypage, container, false)
        // Inflate the layout for this fragment

        requestManager = Glide.with(this)

        v.mypage_steamlist_tv.setOnClickListener(this)
        v.mypage_myreview_tv.setOnClickListener(this)

        v.mypage_steamlist_tv.isSelected = true

        addFragment(MypageSteamListFragment())

        v.mypage_profile_img.setOnClickListener {
            changeImage()
        }

        v.mypage_profile_photo_btn.setOnClickListener {
            changeImage()
        }

        v.frag_mypage_name_layout.setOnClickListener{
            showDialog()
        }

        return v
    }


    fun addFragment(fragment: Fragment) {
        val fm = childFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.fragmnet_mypage_content_layout, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment) {
        val fm = childFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.fragmnet_mypage_content_layout, fragment)
//        transaction.addToBackStack(null)
        transaction.commit()


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
                        input = activity!!.contentResolver.openInputStream(this.data)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }

                    val bitmap = BitmapFactory.decodeStream(input, null, options) // InputStream 으로부터 Bitmap 을 만들어 준다.
                    val baos = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos)
                    val photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray())
                    val img = File(getRealPathFromURI(activity!!,this.data).toString()) // 가져온 파일의 이름을 알아내려고 사용합니다

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

    protected fun showDialog() {
        var dialog = Dialog(activity)
        dialog.setCancelable(true)

        val dialogView = activity!!.layoutInflater.inflate(R.layout.popup_mypage_review, null)
        dialog.setContentView(dialogView)

        dialog.show()


    }



}
