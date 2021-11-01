package com.example.re_grud.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.re_grud.MainActivity
import com.example.re_grud.MainActivity_2
import com.example.re_grud.R
import com.example.re_grud.Signup.Signup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    private val Server = com.example.re_grud.Retro.Server.create()
    var login:Logindata? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d("tag","로그인 화면 시작")
        val loginBut = findViewById<View>(R.id.login);
        val impt2 = findViewById<View>(R.id.join3);
        val idTe = findViewById<EditText>(R.id.text1)
        var ps = findViewById<EditText>(R.id.Textps)


        loginBut.setOnClickListener{
            var email  = idTe.text.toString()
            var password = ps.text.toString()

            val IDPW = Logindata(
                email,password
            )
       Server?.requestLogin(IDPW)?.enqueue(object : Callback<Get_Login>{
           override fun onResponse(call: Call<Get_Login>, response: Response<Get_Login>) {
               var login = response.code().toString()
               Log.d("text","코드확인 ${login}")
               if(login == "200")
               {
                   var dialog = AlertDialog.Builder(this@Login)
                   dialog.setTitle("알람")
                   dialog.show()
                   Log.e("tag", "Main에서 ${response.message()}")
                   Log.e("tag", "Main에서 ${response.code().toString()}")

                   Toast.makeText(this@Login,"로그인 성공", Toast.LENGTH_SHORT).show()
                   val intent = Intent(this@Login, MainActivity_2::class.java)
                   startActivity(intent)

               }else
               {
                   Toast.makeText(this@Login,"로그인 정보가 없습니다. 아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()

               }
           }

           override fun onFailure(call: Call<Get_Login>, t: Throwable) {
               var dialog =AlertDialog.Builder(this@Login)
               dialog.setTitle("실패")
               dialog.setMessage("통신에 실패했습니다")
               dialog.show()
           }

       })

        }
        impt2.setOnClickListener{
            val intent = Intent(this, Signup::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }
    }
}