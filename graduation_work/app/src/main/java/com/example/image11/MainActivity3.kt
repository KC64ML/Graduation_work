package com.example.image11

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainpage)

            val impt1 = findViewById<Button>(R.id.pill);
            val impt2 = findViewById<Button>(R.id.dongwha);
            val impt3 = findViewById<Button>(R.id.study)

            impt1.setOnClickListener{
                val intent = Intent(this, MainActivity::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

                startActivity(intent);

            }

            impt2 .setOnClickListener{

                val intent = Intent(this, MainActivity2::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

                startActivity(intent);

            }
        impt3 .setOnClickListener{

            val intent = Intent(this, MainActivity4::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }



        }
    }

