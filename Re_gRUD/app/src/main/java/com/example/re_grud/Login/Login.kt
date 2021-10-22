package com.example.re_grud.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.re_grud.MainActivity
import com.example.re_grud.R
import com.example.re_grud.Retro.RetroClient.Companion.retrofit
import com.example.re_grud.Retro.Server
import com.example.re_grud.Signup.Signup
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

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
            var IdText  = idTe.text.toString()
            var psText = ps.text.toString()

            var dialog = AlertDialog.Builder(this@Login)
            dialog.setTitle("알람")
            dialog.setMessage("id:" + IdText)
            dialog.show()

            Server?.requestLogin(IdText,psText)?.enqueue(object: retrofit2.Callback<Logindata> {
                override fun onResponse(call: Call<Logindata>, response: Response<Logindata>) {
                    if(response.isSuccessful){
                        Log.d("tag","결과:${response.code()}")
                        login = response.body()
                        Log.d("LOGIN","msg : "+login?.msg)
                        Log.d("LOGIN","code : "+login?.code)
                    }else{
                        Log.d("tag","오류결과:${response.code()}")
                    }

                }

                override fun onFailure(call: Call<Logindata>, t: Throwable) {
                    Log.d("tag:","errora")
                }

            })

            val intent = Intent(this, MainActivity::class.java)//다음화면으로 이동하기위한 인텐트 객체생성
            startActivity(intent);

        }
        impt2.setOnClickListener{
            val intent = Intent(this, Signup::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent);

        }
    }
}