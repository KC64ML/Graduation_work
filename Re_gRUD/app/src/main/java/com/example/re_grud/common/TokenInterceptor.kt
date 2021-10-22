package com.example.re_grud.common

import android.util.Log
import com.example.re_grud.Retro.RetroClient.Companion.prefs

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.util.logging.Logger.global

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.d("tag","TokenInterceptor 확인")
        val builder: Request.Builder = chain.request().newBuilder()
        val jwtToken: String = prefs.getString("token", "NO_TOKEN")
        //Log.e("[Log.e] tag : ", "$jwtToken ")
        if (jwtToken != "NO_TOKEN") {
            builder.addHeader("Authorization", "Bearer $jwtToken")
            Log.e("[Log.e] tag : ", "add header : $jwtToken")
        }
        return chain.proceed(builder.build())
    }
}