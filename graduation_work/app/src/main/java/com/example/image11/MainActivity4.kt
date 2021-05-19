package com.example.image11

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val imst1 = findViewById<ImageButton>(R.id.imageButton25);
        val imst2 = findViewById<ImageButton>(R.id.imageButton26);
        val imst3 = findViewById<ImageButton>(R.id.imageButton11);
        val imst4 = findViewById<ImageButton>(R.id.imageButton16);
        val imst5 = findViewById<ImageButton>(R.id.imageButton23);
        val imst6 = findViewById<ImageButton>(R.id.imageButton24);
        val imst7 = findViewById<ImageButton>(R.id.imageButton32);
        val imst8 = findViewById<ImageButton>(R.id.imageButton31);
        val imst9 = findViewById<ImageButton>(R.id.imageButton29);
        val imst10 = findViewById<ImageButton>(R.id.imageButton27);
        val imst11 = findViewById<ImageButton>(R.id.imageButton30);
        val imst12 = findViewById<ImageButton>(R.id.imageButton28);

        imst1.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kappd.or.kr/kappd/"))


            startActivity(intent)

        }

        imst2 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.worktogether.or.kr/main.do"))


            startActivity(intent)

        }
        imst3 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kawid.or.kr/"))


            startActivity(intent)

        }
        imst4 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.koreanpc.kr/index.do"))


            startActivity(intent)

        }
        imst5 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.koddi.or.kr/"))


            startActivity(intent)

        }
        imst6 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kead.or.kr/"))


            startActivity(intent)

        }
        imst7 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ableservice.or.kr:8443/"))


            startActivity(intent)

        }
        imst8 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.freeget.net/main.php"))


            startActivity(intent)

        }
        imst9 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wis.seoul.go.kr/"))


            startActivity(intent)

        }

        imst10 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hinet.or.kr/"))


            startActivity(intent)

        }
        imst11 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bokjiro.go.kr/pension/"))


            startActivity(intent)

        }
        imst12 .setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.relaycall.or.kr/user/main"))


            startActivity(intent)

        }

    }
}

