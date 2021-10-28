package com.example.re_grud.Calender



import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.edit
import com.example.re_grud.R

class Pass : AppCompatActivity() {


    private val numberPicker1: NumberPicker by lazy{

        findViewById<NumberPicker>(R.id.numberPicker1)
            .apply {

                minValue = 0
                maxValue = 9
            }
    }
    private val numberPicker2: NumberPicker by lazy{

        findViewById<NumberPicker>(R.id.numberPicker2)
            .apply {

                minValue = 0
                maxValue = 9
            }
    }
    private val numberPicker3: NumberPicker by lazy{

        findViewById<NumberPicker>(R.id.numberPicker3)
            .apply {

                minValue = 0
                maxValue = 9
            }
    }
    private val openButton: AppCompatButton by lazy {
        findViewById<AppCompatButton>(R.id.openbutton)
    }
    private  val changepassword:AppCompatButton by lazy{
        findViewById<AppCompatButton>(R.id.changepassword)

    }
    private  var  changepasswordMode = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass)

        numberPicker1
        numberPicker2
        numberPicker3

        openButton.setOnClickListener{

            if(changepasswordMode){
                Toast.makeText(this,"비밀번호변경 중입니다.",Toast.LENGTH_SHORT)
                return@setOnClickListener
            }

            val passwordPreferences =  getSharedPreferences("password",Context.MODE_PRIVATE)

            val passwordFromUser = "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}"

            if (passwordPreferences.getString("password","000").equals(passwordFromUser)){
                //패스워드 성공
                startActivity(Intent(this,CalenderActivity::class.java))

            }else{
                //실패
                showErrorAlertDialog()

            }

            changepassword.setOnClickListener{

                if(changepasswordMode){
                    //번호를 저장하는 기능
                    val passwordPreferences =  getSharedPreferences("password",Context.MODE_PRIVATE)
                    passwordPreferences.edit(true){

                        putString("password",passwordFromUser)

                    }
                    changepasswordMode =false
                    changepassword.setBackgroundColor(Color.BLUE)

                }else{
                    //changePasswordmode 가 활성화:: 비밀번호가 맞는지를 체크
                    val passwordPreferences =  getSharedPreferences("password",Context.MODE_PRIVATE)

                    val passwordFromUser = "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}"

                    if (passwordPreferences.getString("password","000").equals(passwordFromUser)){
                        //패스워드 성공
                        //startActivity()
                        changepassword.setBackgroundColor(Color.WHITE)

                        Toast.makeText(this,"변경할 패스워드를 입력하세요",Toast.LENGTH_SHORT).show()
                        changepasswordMode = true

                    }else{
                        //실패
                        showErrorAlertDialog()

                    }
                }

            }
        }

    }
    private fun showErrorAlertDialog(){
        AlertDialog.Builder(this)
            .setTitle("실패!!")
            .setMessage("비밀번호가 잘못되었습니다.")
            .setPositiveButton("확인")   {
                    dialog, which -> }
            .create()
            .show()

    }
}