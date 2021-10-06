package image11.graduation.ok.com

import android.content.Intent
import android.os.Bundle
import android.telephony.RadioAccessSpecifier
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.sulmun1.*
import kotlinx.android.synthetic.main.sulmun2.*
import org.jetbrains.anko.find

class survey2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sulmun2)
        var count = 0;


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
            val intent = Intent(this, survey3::class.java)

            startActivity(intent);

        }
    }}