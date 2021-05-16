package com.example.image11

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.edit

import com.example.image11.AlarmDisplayModel
import com.example.image11.R
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mainalarm)
        //뷰를 초기화해주기
        //데이터 가져오기
        //뷰에 데이터를 그려주기
        initOnOffButton()
        initChangeAlarmTimeButton()


    }

    private fun initOnOffButton() {
        val onOffButton = findViewById<ImageButton>(R.id.onOffButton)//이미지버튼 가져오기기
       onOffButton.setOnClickListener {
//저장한 데이터를 확인
//온 오프에 따라 작업을 처리한다.

//오프 ->알람제거  온 -> 알람을 등록
//데이터를 저장한다.


        }
    }

    private fun initChangeAlarmTimeButton() {
        val changeAlarmButton = findViewById<ImageButton>(R.id.changeAlarmTimeButton)
        changeAlarmButton.setOnClickListener {
//현재시간을 일단 가져온다.
            //TimePickDialog 띄워줘서 시간을 설정하도록 하고, 그 시간을 가지고 와서
            //데이터를 저장한다.
            //뷰를 업데이트한다.
            //기존에 있던 알람을 삭제한다.
            val calendar = Calendar.getInstance() //자바의 캘린더를 가져온다.
            TimePickerDialog(this, { picker, hour, minute -> //람다생성

                val model = saveAlarmModel(hour, minute, false)


            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show()

        }

    }

    private fun saveAlarmModel( //데이터를 저장하는 함수
        hour: Int,
        minute: Int,
        onOff: Boolean
    ): AlarmDisplayModel {
        val model = AlarmDisplayModel(
            hour = hour,
            minute = minute,
            onOff = onOff
        )

        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

        with(sharedPreferences.edit()) {
            putString(ALARM_KEY, model.makeDataForDB())
            putBoolean(ONOFF_KEY, model.onOff)
            commit()
        }

        return model
    }






    companion object {
        private const val SHARED_PREFERENCES_NAME = "time"
        private const val ALARM_KEY = "alarm"
        private const val ONOFF_KEY = "onOff"
        private const val ALARM_REQUEST_CODE = 1000

    }
}