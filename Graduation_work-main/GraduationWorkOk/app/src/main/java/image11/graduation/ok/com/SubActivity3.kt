package image11.graduation.ok.com
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class SubActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val v: VideoView = findViewById(R.id.videoView2)

        v.setVideoPath("android.resource://image11.graduation.ok.com/"+R.raw.namu)

        v.start()

        v.setOnPreparedListener{
                m: MediaPlayer ->

            m.setOnVideoSizeChangedListener {

                    m: MediaPlayer?, width:Int, height:Int ->

                val mediaController = MediaController(this)

                v.setMediaController(mediaController)

                mediaController.setAnchorView(v)






            }

        }
    }
}