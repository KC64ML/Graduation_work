package image11.graduation.ok.com

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView


class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        val v:VideoView = findViewById(R.id.videoView2)

        v.setVideoPath("android.resource://image11.graduation.ok.com/"+R.raw.hankuk11)

        v.start()

        v.setOnPreparedListener{
                m:MediaPlayer ->

            m.setOnVideoSizeChangedListener {

                    m: MediaPlayer?, width:Int,height:Int ->

                val mediaController = MediaController(this)

                v.setMediaController(mediaController)

                mediaController.setAnchorView(v)






            }

        }
        val imbt1 = findViewById<ImageButton>(R.id.imageButton5);
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