package com.example.re_grud.common

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class mySharedPreferences(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("com.example.re_grud.common", Context.MODE_PRIVATE)

    fun getString(key: String, defValue: String?): String {
        Log.d("tag","myShared getString 위치")
        return prefs.getString(key, defValue).toString()
    }

    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }

}