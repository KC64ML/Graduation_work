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
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Regist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.check)

        Log.d("text","check 하겠습니다. 회원가입쪾")

        val copy = findViewById<View>(R.id.copy);
        val join131 = findViewById<View>(R.id.join131);
        val username = findViewById<EditText>(R.id.check_Username);

        val password = findViewById<EditText>(R.id.check_password);
        val age = findViewById<EditText>(R.id.check_age);
        val birth = findViewById<EditText>(R.id.check_birth);
        val email = findViewById<EditText>(R.id.check_email);
        val  phone = findViewById<EditText>(R.id.check_phone);
        val family = findViewById<EditText>(R.id.check_Family);

        var retroit = Retrofit.Builder()
            .baseUrl("http://192.168.195.170:8000/")//서버주수 적어야함
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var loginService = retroit.create(LoginService::class.java)



        join131.setOnClickListener{

            var textId = username.text.toString()
            var textpw = password.text.toString()
            var textbirth = birth.text.toString()
            var textemail = email.text.toString()
            var phone = phone.text.toString()
            var family = family.text.toString()
            var age = age.text.toString()
            var s = signup_data(
                textId, textpw,phone,textemail,family,age,
                textbirth)

            Log.d("test","retrofit 테스트 시작")

            loginService.requestLogin(s).enqueue(object: Callback<signup_data> {
                override fun onFailure(call: Call<signup_data>, t: Throwable) {
                    //웹통신에 실패했을때 실행되는 코드
                    var dialog = AlertDialog.Builder(this@Regist)
                    dialog.setTitle("실패!")
                    dialog.setMessage("통신에 실패했습니다.")

                    dialog.show()
                    Log.d("hello","error : ${t.message}")
                }
                override fun onResponse(call: Call<signup_data>, response: Response<signup_data>) {
                    //웹통신에 성공했을때 실행되는 코드
                    var login = response.body()

                    var dialog = AlertDialog.Builder(this@Regist)
                    dialog.setTitle("알람")

                    dialog.show()
                    Log.e("tag","Main에서 ${response.message()}")
                    Log.e("tag","Main에서 ${response.code().toString()}")
                }

            })
        }
    }
}


