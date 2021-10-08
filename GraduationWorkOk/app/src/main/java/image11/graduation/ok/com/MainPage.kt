package image11.graduation.ok.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import image11.graduation.ok.com.common.global.Companion.prefs


class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainpagecheck)

        val imst1 = findViewById<View>(R.id.donghwa_final);
        val imst2 = findViewById<View>(R.id.location_final);
        val imst3 = findViewById<View>(R.id.pill_final);
        val imst4 = findViewById<View>(R.id.diary_final);
        val imst5 = findViewById<View>(R.id.survey_final);
        val imst6 = findViewById<View>(R.id.game_final);

        val imst7 = findViewById<View>(R.id.education_final);
        imst1.setOnClickListener{
            val intent = Intent(this, SubActivity4::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }

        imst6.setOnClickListener {
            if (prefs.getString("token", "NO_TOKEN") == "NO_TOKEN") {
                Toast.makeText(
                    this, "로그인 정보가 없습니다." +
                            "\n로그인 화면으로 이동합니다.", Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            } else {
                startActivity(mypageIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            }
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