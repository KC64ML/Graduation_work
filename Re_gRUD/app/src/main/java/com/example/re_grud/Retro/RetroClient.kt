package com.example.re_grud.Retro

import android.app.Application

import com.example.re_grud.common.TokenInterceptor
import com.example.re_grud.common.mySharedPreferences
import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetroClient : Application() {
    companion object {
        var BASE_URL = "https://dongagd.herokuapp.com/"

        lateinit var prefs: mySharedPreferences



        var retrofit: Retrofit? = null
        fun getInstance(): Retrofit? {
            if (retrofit == null) {
                val client: OkHttpClient = OkHttpClient.Builder()
                    .readTimeout(10000, TimeUnit.MILLISECONDS)
                    .connectTimeout(10000, TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(TokenInterceptor()) // JWT 자동 헤더 전송
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return retrofit
        }

    }


    override fun onCreate() {
        super.onCreate()

        prefs = mySharedPreferences(applicationContext)

        // KakaoSdk.init(this, getString(R.string.kakao_app_key))
    }

}