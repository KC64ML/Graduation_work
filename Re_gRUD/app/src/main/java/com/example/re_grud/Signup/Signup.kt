package com.example.re_grud.Signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.re_grud.Login.Get_List
import com.example.re_grud.Login.Login
import com.example.re_grud.Login.UserCreationElement
import com.example.re_grud.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Signup : AppCompatActivity() {
    private val Server = com.example.re_grud.Retro.Server.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val join131 = findViewById<View>(R.id.join131);
        val username = findViewById<EditText>(R.id.check_Username);

        val pass = findViewById<EditText>(R.id.check_password);
        val age = findViewById<EditText>(R.id.check_age);
        val birth = findViewById<EditText>(R.id.check_birth);
        val email = findViewById<EditText>(R.id.check_email);
        val  phone = findViewById<EditText>(R.id.check_phone);
        val family = findViewById<EditText>(R.id.check_Family);


        val button = findViewById<View>(R.id.copy)

        join131.setOnClickListener {
            var email = email.text.toString()
            var birth = birth.text.toString()
            var phone = phone.text.toString()
            var family = family.text.toString()
            var password = pass.text.toString()
            val age = age.text.toString()
            val username = username.text.toString()





            Log.d("에러 첵","길이:${username.length}")
            if(username.length >45 || username.isEmpty()) {
                Toast.makeText(this, "아이디 45이하로 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else if (password.length >128 || password.isEmpty()) {
                Toast.makeText(this, "비밀번호를 128자 이하로 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else if (email.length > 64 || email.isEmpty()){
                    Toast.makeText(this,"이메일 64자 이하로 입력해주세요",Toast.LENGTH_SHORT).show()
            }
            else if(family.length>5 || family.isEmpty()){
                Toast.makeText(this,"성별 5이하로 입력해주세요",Toast.LENGTH_SHORT).show()
            }
            else if(age.length >3|| age.isEmpty()){
                Toast.makeText(this,"나이를 3 이하로 입력해주세요",Toast.LENGTH_SHORT).show()
            }
            else if(birth.length>6||birth.isEmpty()){
                Toast.makeText(this,"생년월일을 6자이하로 입력해주세요",Toast.LENGTH_SHORT).show()
            }else {
                val ucelement = UserCreationElement(
                    username, password, phone, email, family, age, birth
                )




                Server?.userlogin(ucelement)?.enqueue(object : Callback<Get_List> {
                    override fun onResponse(call: Call<Get_List>, response: Response<Get_List>) {
                        if (response.isSuccessful) {

                            Log.d("tag", "결과:${response.code()}")
                            Toast.makeText(this@Signup, "회원가입 성공", Toast.LENGTH_SHORT).show()
                        } else {

                            Log.d("tag", "${response.code().toString()}")
                            Log.e("tag", "onFailure" + response.message())
                        }
                    }

                    override fun onFailure(call: Call<Get_List>, t: Throwable) {
                        Log.d("tag:", "errora")
                    }
                })
            }
             /*Server?.userlogin(ucelement)
                 ?.enqueue(object : Callback<Get_List>
                 {
                     override fun onResponse(call: Call<Get_List>, response: Response<Get_List>) {
                      if(response.isSuccessful)
                      {

                          Log.d("tag","결과:${response.code()}")
                      }else
                      {

                          Log.d("tag","${response.code().toString()}")
                          Log.e("tag","onFailure" + response.message())
                      }
                     }

                     override fun onFailure(call: Call<Get_List>, t: Throwable) {
                         Log.d("tag:","errora")
                     }


                 })
*/
            val intent = Intent(baseContext, Login::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finish()


        }


    }


}