package com.example.image11

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import com.example.image11.R



class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imbt1 = findViewById<ImageButton>(R.id.imageButton);
        val imbt2 = findViewById<ImageButton>(R.id.imageButton2);
        val imbt3 = findViewById<ImageButton>(R.id.imageButton3);
        val imbt4 = findViewById<ImageButton>(R.id.imageButton4);


        imbt1.setOnClickListener{
            val intent = Intent(this, SubActivity4::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }

        imbt2 .setOnClickListener{

            val intent = Intent(this, SubActivity1::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }

        imbt3 .setOnClickListener{

            val intent = Intent(this, SubActivity2::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }
        imbt4.setOnClickListener{

            val intent = Intent(this, SubActivity3::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }







    }
}