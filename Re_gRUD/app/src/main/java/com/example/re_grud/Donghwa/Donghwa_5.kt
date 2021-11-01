package com.example.re_grud.Donghwa

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.re_grud.R

class Donghwa_5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donghwa5)

        val v: VideoView = findViewById(R.id.videoView2)

      /*  v.setVideoPath("android.resource://image11.graduation.ok.com/"+ R.raw.gold)*/

        v.start()

        v.setOnPreparedListener{
                m: MediaPlayer ->

            m.setOnVideoSizeChangedListener {

                    m: MediaPlayer?, width:Int, height:Int ->

                val mediaController = MediaController(this)

                v.setMediaController(mediaController)

                mediaController.setAnchorView(v)






            }

        }
    }
}