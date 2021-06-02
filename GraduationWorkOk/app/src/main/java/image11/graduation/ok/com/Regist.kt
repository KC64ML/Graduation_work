package image11.graduation.ok.com

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class Regist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.check)

        Log.d("text","check 하겠습니다. 회원가입쪾")

        val copy = findViewById<View>(R.id.copy);
        val join131 = findViewById<View>(R.id.join131);
        val username = findViewById<EditText>(R.id.check_Username);

//        val password = findViewById<EditText>(R.id.check_password);
//        val age = findViewById<EditText>(R.id.check_age);
//        val birth = findViewById<EditText>(R.id.check_birth);
//        val email = findViewById<EditText>(R.id.check_email);
//        val  phone = findViewById<EditText>(R.id.check_phone);
//        val family = findViewById<EditText>(R.id.check_Family);

        join131.setOnClickListener{
            Log.d("text","check 입력확인")
        }
        join131.setOnClickListener{


        }

        username.setOnClickListener{
            val test = username.text.toString()
            Log.d("text","${test}")

        }

//        password.setOnClickListener{
//            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kappd.or.kr/kappd/"))
//
//
//            startActivity(intent)
//
//        }
//
        join131.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kappd.or.kr/kappd/"))
            Log.d("text","check 입력확인")
//
            startActivity(intent)
//
        }
//
//        birth.setOnClickListener{
//            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kappd.or.kr/kappd/"))
//
//
//            startActivity(intent)
//
//        }
//
//        email.setOnClickListener{
//            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kappd.or.kr/kappd/"))
//
//
//            startActivity(intent)
//
//        }
//
//        phone.setOnClickListener{
//            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kappd.or.kr/kappd/"))
//
//
//            startActivity(intent)
//
//        }
//        family.setOnClickListener{
//            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kappd.or.kr/kappd/"))
//
//
//            startActivity(intent)
//
//        }


    }
}