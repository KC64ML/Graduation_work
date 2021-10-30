package com.example.re_grud.Survey

import android.content.Intent
import android.os.Bundle
import android.telephony.RadioAccessSpecifier
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.re_grud.MainActivity_2
import com.example.re_grud.R
import kotlinx.android.synthetic.main.activity_survey3.*

import org.jetbrains.anko.find

class Survey_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey3)
        var count = 0;
        var textresult : TextView
        var rg9 : RadioGroup
        var rg10 : RadioGroup

       textresult = findViewById<TextView>(R.id.result)
        rg9 = findViewById<RadioGroup>(R.id.rg9)
        rg10 = findViewById<RadioGroup>(R.id.rg10)

        rg9.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when (checkedId) {
                R.id.radio41 -> count += 2;
                R.id.radio42 -> count += 4;
                R.id.radio43 -> count += 6;
                R.id.radio44 -> count += 8;
                R.id.radio45 -> count += 10;


            }
        }
        rg10.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when (checkedId) {
                R.id.radio46 -> count += 2;
                R.id.radio47 -> count += 4;
                R.id.radio48 -> count += 6;
                R.id.radio49 -> count += 8;
                R.id.radio50 -> count += 10;


            }
           finish1.setOnClickListener {
               intent = Intent(this,MainActivity_2::class.java)

               startActivity(intent)
           }

          //  textresult.text = " 점수는? " + count.toString()





        }
    }}