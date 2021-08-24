package image11.graduation.ok.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main123)

        val imst1 = findViewById<View>(R.id.education1);
        val imst2 = findViewById<View>(R.id.locaion1);
        val imst3 = findViewById<View>(R.id.donghwa1);
        val imst4 = findViewById<View>(R.id.pill12);
        val diary = findViewById<View>(R.id.diary123)


        imst1.setOnClickListener{
            val intent = Intent(this, MainActivity4::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

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

        imst4.setOnClickListener{
            val intent = Intent(this,MainActivity6::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }

        diary.setOnClickListener {
            val intent = Intent(this,pass::class.java)
            startActivity(intent)
        }
        System.out.println("test_2");
        System.out.println("test_3");
        System.out.println("test_4");
        System.out.println("test_5");
        System.out.println("test_6");

        
    }
}