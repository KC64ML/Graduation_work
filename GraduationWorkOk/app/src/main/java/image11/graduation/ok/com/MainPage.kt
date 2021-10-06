package image11.graduation.ok.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainpagecheck)

        val imst1 = findViewById<View>(R.id.donghwa_check);
        val imst2 = findViewById<View>(R.id.location_check);
        val imst3 = findViewById<View>(R.id.pill_check);
        val imst4 = findViewById<View>(R.id.mynote_check);
        val imst5 = findViewById<View>(R.id.survey_check);
        val imst6 = findViewById<View>(R.id.game_check);

        val imst7 = findViewById<View>(R.id.education_check);
        imst1.setOnClickListener{
            val intent = Intent(this, SubActivity4::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }

        imst6.setOnClickListener {
            val intent = Intent(this,Memory::class.java)
            startActivity(intent);
        }

        imst2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }


        imst3.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }

        imst7.setOnClickListener{
            val intent = Intent(this,MainActivity4::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }

        imst4.setOnClickListener {
            val intent = Intent(this,pass::class.java)
            startActivity(intent)
        }

        imst5.setOnClickListener {
            val intent = Intent(this,survey::class.java)
            startActivity(intent)
        }


    }
}