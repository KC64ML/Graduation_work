package com.example.re_grud

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.re_grud.Alarm.ALARM
import com.example.re_grud.Login.Login
import org.w3c.dom.Text

class AppVedio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vedio)

        var Yes_btn : ImageButton
        var No_btn : ImageButton


        Yes_btn = findViewById<ImageButton>(R.id.Yes_Button)
        No_btn = findViewById<ImageButton>(R.id.No_Button)

        Yes_btn.setOnClickListener{

            val intent = Intent(this, MainActivity_2::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);



        }
        No_btn.setOnClickListener{

            finish()
        }

        val v: VideoView = findViewById(R.id.videoView2)

        v.setVideoPath("android.resource://com.example.re_grud/"+R.raw.mainvedio)

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


    }}









