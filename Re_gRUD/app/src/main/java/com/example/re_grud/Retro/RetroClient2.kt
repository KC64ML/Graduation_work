package com.example.re_grud.Retro

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClient2 {
    private var instance: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    fun getInstance() : Retrofit
    {
        if(instance == null)
        {
            instance = Retrofit.Builder()
                .baseUrl("https://dongagd.herokuapp.com/" )
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        }
        return instance !!

    }
}