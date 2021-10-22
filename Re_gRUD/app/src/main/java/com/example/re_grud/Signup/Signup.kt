package com.example.re_grud.Signup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.re_grud.Login.Get_List
import com.example.re_grud.Login.Login
import com.example.re_grud.Login.UserCreationElement
import com.example.re_grud.R
import com.example.re_grud.Retro.Server
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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



            val ucelement = UserCreationElement(
                username,password,phone,email,family,age,birth
            )

             Server?.userlogin(ucelement)
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
            val intent = Intent(baseContext, Login::class.java)//다음화면으로 이동하기위한 인텐트 객체생성

            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finish()


        }


    }


}