package com.example.re_grud.Intro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.re_grud.MainActivity_2
import com.example.re_grud.R

class AppIntro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    { super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        var handler = Handler()
        handler.postDelayed( {
            var intent = Intent( this, MainActivity_2::class.java)
            startActivity(intent)
        }, 1400) }
    override fun onPause() {
        super.onPause()
        finish()
    } }
