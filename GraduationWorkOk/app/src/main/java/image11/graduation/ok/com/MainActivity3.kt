package image11.graduation.ok.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.appfirst)
            val impt1 = findViewById<View>(R.id.firstButton);

            impt1.setOnClickListener{
                val intent = Intent(this, login::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

                startActivity(intent);

            }


//변경확인
        }
    }

