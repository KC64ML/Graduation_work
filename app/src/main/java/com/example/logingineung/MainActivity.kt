package com.example.logingineung

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    findViewById<EditText>(R.id.id)
        findViewById<EditText>(R.id.password)

        var retroit = Retrofit.Builder()
            .baseUrl("")//서버주수 적어야함
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var loginService = retroit.create(LoginService::class.java)


        button.setOnClickListener{
        var textId = id.text.toString()
            var textPw = password.text.toString()

            loginService.requrstLogin(textId,textPw).enqueue(object:Callback<Login>{
                override fun onFailure(call: Call<Login>, t: Throwable) {
                            //웹통신에 실패했을때 실행되는 코드
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("실패!")
                    dialog.setMessage("통신에 실패했습니다.")
                    dialog.show()
                    }

                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                        //웹통신에 성공했을때 실행되는 코드
                    var login = response.body()

                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("알람")
                    dialog.setMessage("code=" + login?.code+", msg="+ login?.msg)
                    dialog.show()
                    }

            })


            }

    }
}