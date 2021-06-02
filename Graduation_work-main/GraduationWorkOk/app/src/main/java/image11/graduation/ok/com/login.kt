package image11.graduation.ok.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login11)

        val impt1 = findViewById<View>(R.id.login);
        val impt2 = findViewById<View>(R.id.join3);

        impt1.setOnClickListener{
            val intent = Intent(this, MainPage::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }
        impt2.setOnClickListener{
            val intent = Intent(this, Regist::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }
    }
}