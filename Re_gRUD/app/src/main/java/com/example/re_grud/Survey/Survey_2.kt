package com.example.re_grud.Survey


import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.re_grud.R


class Survey_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey2)
        var count = 0;

        var rg5 : RadioGroup
        var rg6 : RadioGroup
        var rg7 : RadioGroup
        var rg8 : RadioGroup


        rg5 = findViewById<RadioGroup>(R.id.rg5)
        rg6 = findViewById<RadioGroup>(R.id.rg6)
        rg7 = findViewById<RadioGroup>(R.id.rg7)
        rg8 = findViewById<RadioGroup>(R.id.rg8)
        val nextpage2 = findViewById<TextView>(R.id.nextpage1)
        rg5.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when (checkedId) {
                R.id.radio21 -> count += 2;
                R.id.radio22 -> count += 4;
                R.id.radio23 -> count += 6;
                R.id.radio24 -> count += 8;
                R.id.radio25 -> count += 10;


            }
        }
        rg6.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when (checkedId) {
                R.id.radio26-> count += 2;
                R.id.radio27 -> count += 4;
                R.id.radio28 -> count += 6;
                R.id.radio29 -> count += 8;
                R.id.radio30 -> count += 10;


            }

        }

        rg7.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when(checkedId) {
                R.id.radio31 -> count += 2;
                R.id.radio32 -> count += 4;
                R.id.radio33 -> count += 6;
                R.id.radio34 -> count += 8;
                R.id.radio35 -> count += 10;
            }

        }
        rg8.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when(checkedId){
                R.id.radio36 -> count +=2;
                R.id.radio37 -> count +=4;
                R.id.radio38 -> count +=6;
                R.id.radio39 -> count +=8;
                R.id.radio40 -> count +=10;


            }
        }
        nextpage2.setOnClickListener{
            val intent = Intent(this, Survey_3::class.java)

            startActivity(intent);

        }
    }}