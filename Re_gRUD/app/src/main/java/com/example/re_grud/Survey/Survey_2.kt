package com.example.re_grud.Survey


import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.re_grud.R
import kotlinx.android.synthetic.main.activity_survey.*
import kotlinx.android.synthetic.main.activity_survey.nextpage
import kotlinx.android.synthetic.main.activity_survey2.*
import kotlinx.android.synthetic.main.activity_survey3.*


class Survey_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey2)
        var result: TextView
        var count1: Int = 0

        var textresult: TextView
        var rg5: RadioGroup
        var rg6: RadioGroup
        var rg7: RadioGroup
        var rg8: RadioGroup
        var countfinal1 : Int
        var Test: Int = 0

        textresult = findViewById<TextView>(R.id.textresult)
        rg5 = findViewById<RadioGroup>(R.id.rg5)
        rg6 = findViewById<RadioGroup>(R.id.rg6)
        rg7 = findViewById<RadioGroup>(R.id.rg7)
        rg8 = findViewById<RadioGroup>(R.id.rg8)
        val nextpage2 = findViewById<TextView>(R.id.nextpage1)
        rg5.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when (checkedId) {
                R.id.radio21 -> count1 += 2;
                R.id.radio22 -> count1 += 4;
                R.id.radio23 -> count1 += 6;
                R.id.radio24 -> count1 += 8;
                R.id.radio25 -> count1 += 10;


            }
        }

        rg6.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when (checkedId) {
                R.id.radio26 -> count1 += 2;
                R.id.radio27 -> count1 += 4;
                R.id.radio28 -> count1 += 6;
                R.id.radio29 -> count1 += 8;
                R.id.radio30 -> count1 += 10;


            }

        }

        rg7.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when (checkedId) {
                R.id.radio31 -> count1 += 2;
                R.id.radio32 -> count1 += 4;
                R.id.radio33 -> count1 += 6;
                R.id.radio34 -> count1 += 8;
                R.id.radio35 -> count1 += 10;
            }

        }
        rg8.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when (checkedId) {
                R.id.radio36 -> count1 += 2;
                R.id.radio37 -> count1 += 4;
                R.id.radio38 -> count1 += 6;
                R.id.radio39 -> count1 += 8;
                R.id.radio40 -> count1 += 10;


            }

            countfinal1 = count1

            nextpage1.setOnClickListener {

                val intent = Intent(this, Survey_3::class.java)


                startActivity(intent)
            }

            var value1 = intent.getStringExtra("JUMSU")

            textresult.text = " 점수는? " + value1 + countfinal1




        }

    }

    }