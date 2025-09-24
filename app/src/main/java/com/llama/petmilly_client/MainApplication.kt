package com.llama.petmilly_client

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
//import com.kakao.sdk.common.KakaoSdk
//import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    companion object {
        private lateinit var sharedPreferences: SharedPreferences
        lateinit var instance: MainApplication
        var signupname = ""

        var categorylist = listOf<String>(
            "강아지", "고양이", "petmily ❤️", "~7kg", "7~15kg", "15kg~"
        )

//        fun saveAcceasdasdssToken(accessToken1: String) {
//            val editor = sharedPreferences.edit()
//            editor.putString(Common.ACCESSTOKEN, accessToken1)
//            editor.apply()
//        }

//        fun saveRefreshToken(refreshToken: String) {
//            val editor = sharedPreferences.edit()
//            editor.putString(REFRESHTOKEN, refreshToken)
//            editor.apply()
//        }
//
//
//        fun saveisLogin(refreshToken: Boolean) {
//            val editor = sharedPreferences.edit()
//            editor.putBoolean(ISLOGIN, refreshToken)
//            editor.apply()
//        }


//        fun getAccessToken(): String? {
//            return sharedPreferences.getString(ACCESSTOKEN, "")
//        }
//
//        fun getRefreshToken():String? {
//            return sharedPreferences.getString(REFRESHTOKEN, "")
//        }
//
//        fun getisLogin() : Boolean{
//            return sharedPreferences.getBoolean(ISLOGIN, false)
//        }

//        fun Logout() {
//            saveAccessToken("")
//            saveRefreshToken("")
//            saveisLogin(false)
//        }

    }


    override fun onCreate() {
        super.onCreate()

        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)

//        Log.d(TAG, "로그인 확인 : ${getisLogin()}")
//        var keyHash = Utility.getKeyHash(this)
//        KakaoSdk.init(this, getString(R.string.kakao_api_key))

    }

}