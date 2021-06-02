package image11.graduation.ok.com

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import org.jetbrains.anko.toast

class CalenderActivity : AppCompatActivity() {
    lateinit var myHelper: MyDBHelper
    lateinit var sqlDB:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)

        myHelper = MyDBHelper(this,"DiaryDB",null,1)
        sqlDB = myHelper.writableDatabase

        val calender = findViewById<CalendarView>(R.id.calender)
        val saveBtn = findViewById<Button>(R.id.saveBtn)
        val selectDate = findViewById<TextView>(R.id.selectDate)
        val diaryContents = findViewById<EditText>(R.id.diarycontent)
        val saveDiary = findViewById<TextView>(R.id.saveDiary)
        val deleteBtn = findViewById<Button>(R.id.deleteBtn)
        val modification = findViewById<Button>(R.id.modification)

        calender.setOnDateChangeListener { _, year, month, dayOfMonth ->

            saveDiary.visibility = View.INVISIBLE
            modification.visibility = View.INVISIBLE
            selectDate.visibility = View.INVISIBLE
            selectDate.setText("$year 년 ${month+1} 월 $dayOfMonth 일 ")
            diaryContents.setText("")
            diaryContents.visibility = View.VISIBLE
            saveBtn.visibility = View.VISIBLE
            deleteBtn.visibility = View.VISIBLE

            sqlDB = myHelper.readableDatabase
            val c1:Cursor //커서
            c1 = sqlDB.rawQuery("select * from DiaryTBL",null) //조회
            var strSaveDiary1:String

            while (c1.moveToNext()){

                var columDate1:String = c1.getString(0)
                var selDate1:String = selectDate.text.toString()


//                if(columDate1 == selDate1)
//                {
//                    saveDiary.visibility = View.INVISIBLE
//
//
//
//                }

                if (columDate1 == selDate1)
                {
                    strSaveDiary1 = c1.getString(1)
                    diaryContents.visibility = View.INVISIBLE
                    saveBtn.visibility = View.INVISIBLE
                  saveDiary.text = strSaveDiary1
                    saveDiary.visibility = View.VISIBLE
                    deleteBtn.visibility = View.VISIBLE

                    modification.setOnClickListener {
                        saveDiary.visibility = View.INVISIBLE
                        modification.visibility = View.INVISIBLE
                        deleteBtn.visibility = View.INVISIBLE
                        diaryContents.visibility = View.VISIBLE
                        diaryContents.setText(saveDiary.text.toString())
                        saveBtn.visibility = View.VISIBLE

                        saveBtn.setOnClickListener {
                            Log.d("text","수정하는 곳")
                            sqlDB = myHelper.writableDatabase
                            sqlDB.execSQL("update DiaryTBL set diary = '"
                                    +diaryContents.text.toString()
                                    + "' where (date = '"
                                    +selectDate.text.toString()+"');")
                            diaryContents.visibility = View.INVISIBLE
                            saveBtn.visibility = View.INVISIBLE
                            saveDiary.visibility = View.VISIBLE
                            modification.visibility = View.VISIBLE
                            deleteBtn.visibility = View.VISIBLE
                        }


                    }
                    deleteBtn.setOnClickListener {

                        Log.d("text","삭제하는 곳")
                        saveBtn.visibility = View.INVISIBLE
                        modification.visibility = View.INVISIBLE
                        deleteBtn.visibility = View.INVISIBLE
                        diaryContents.setText("")


                        sqlDB = myHelper.writableDatabase
                        sqlDB.execSQL("delete from DiaryTBL where (date = '"

                                +selectDate.text.toString()+"');")

                        diaryContents.visibility = View.VISIBLE
                        saveBtn.visibility = View.VISIBLE
                    }

                }
            }
            saveBtn.setOnClickListener {
                if(diaryContents.text.toString() == ""){
                    toast("저장할내용이 없습니다.")
                }else
                {
                    diaryContents.visibility = View.INVISIBLE
                    saveBtn.visibility = View.INVISIBLE
                    sqlDB.execSQL("insert into DiaryTBL values('"
                            +selectDate.text.toString()
                            +"','"+diaryContents.text.toString()+"');")

                    sqlDB = myHelper.readableDatabase //db의 DiaryTBL 테이블

                    val c:Cursor
                    c = sqlDB.rawQuery("select * from DiaryTBL;", null)

                    var strSaveDiary:String=""

                    while (c.moveToNext()){
                        var columDate:String = c.getString(0)
                        var selDate:String = selectDate.text.toString()
                        if(columDate == selDate){
                            strSaveDiary1 = c.getString(1)

                        }

                    }
                    saveDiary.text =  strSaveDiary
                    saveDiary.visibility = View.VISIBLE
                    modification.visibility = View.VISIBLE
                    deleteBtn.visibility = View.VISIBLE


                }
            }


        }

    }

    override fun onDestroy() {
        sqlDB.close()
        super.onDestroy()
    }
    class MyDBHelper(
        context: Context?,
        name: String?,
        factory: SQLiteDatabase.CursorFactory?,
        version: Int
    ) : SQLiteOpenHelper(context, name, factory, version) {
        override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL("create table DiaryTBL(date char(30),diary char(1000))")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db?.execSQL("drop table if exists DiaryTBL")
            onCreate(db)
        }
    }
}