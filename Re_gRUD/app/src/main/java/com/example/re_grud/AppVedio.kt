package com.example.re_grud

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.re_grud.Alarm.ALARM
import com.example.re_grud.Login.Login
import org.w3c.dom.Text

class AppVedio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vedio)

        var Yes_btn : Button
        var No_btn : Button
        Yes_btn = findViewById<Button>(R.id.Yes_Button)
        No_btn = findViewById<Button>(R.id.No_Button)

        Yes_btn.setOnClickListener{

            val intent = Intent(this, MainActivity_2::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);



        }
   No_btn.setOnClickListener{

       finish()
   }




    }}