package com.example.re_grud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.re_grud.Donghwa.Donghwa
import com.example.re_grud.Login.Login
import com.example.re_grud.Retro.RetroClient.Companion.prefs


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val main_dongahwa = findViewById<View>(R.id.donghwa_final);
        val main_location = findViewById<View>(R.id.location_final);
        val main_pill = findViewById<View>(R.id.pill_final);
        val main_diary = findViewById<View>(R.id.diary_final);
        val main_survey = findViewById<View>(R.id.survey_final);
        val main_game = findViewById<View>(R.id.game_final);

        val main_education = findViewById<View>(R.id.education_final);

        val main_go_donga = Intent(this, Donghwa::class.java)
        main_game.setOnClickListener{
            val intent = Intent(this, Donghwa::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }
        Log.d("tag","main_donghwa 클릭하기전")
        main_dongahwa.setOnClickListener {
            Log.d("tag","main_dongahwa 클릭")
            if (prefs.getString("token", "NO_TOKEN") == "NO_TOKEN") {
                Toast.makeText(
                    this, "로그인 정보가 없습니다." +
                            "\n로그인 화면으로 이동합니다.", Toast.LENGTH_SHORT
                ).show()
                Log.d("tag","Main : setOnClick 동아")
                val intent = Intent(this, Login::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            } else {
                startActivity(main_go_donga.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            }
        }


/*
        main_location.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }


        main_pill.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }

        main_education.setOnClickListener{
            val intent = Intent(this,MainActivity4::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }*/

       /* main_diary.setOnClickListener {
            val intent = Intent(this,pass::class.java)
            startActivity(intent)
        }

        main_survey.setOnClickListener {
            val intent = Intent(this,survey::class.java)
            startActivity(intent)
        }*/


    }
}