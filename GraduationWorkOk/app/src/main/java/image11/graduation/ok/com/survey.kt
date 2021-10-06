package image11.graduation.ok.com

import android.content.Intent
import android.os.Bundle
import android.telephony.RadioAccessSpecifier
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.sulmun1.*
import org.jetbrains.anko.find

class survey : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sulmun1)
        var count = 0;




        rg1.setOnCheckedChangeListener { Radiogroup, checkedId ->
        var nextpage = findViewById<TextView>(R.id.nextpage)
            when (checkedId) {
                R.id.radio1 -> count += 2;
                R.id.radio2 -> count += 4;
                R.id.radio3 -> count += 6;
                R.id.radio4 -> count += 8;
                R.id.radio5 -> count += 10;


            }
        }
        rg2.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when (checkedId) {
                R.id.radio6-> count += 2;
                R.id.radio7 -> count += 4;
                R.id.radio8 -> count += 6;
                R.id.radio9 -> count += 8;
                R.id.radio10 -> count += 10;


            }

        }

        rg3.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when(checkedId) {
                R.id.radio11 -> count += 2;
                R.id.radio12 -> count += 4;
                R.id.radio13 -> count += 6;
                R.id.radio14 -> count += 8;
                R.id.radio15 -> count += 10;
            }

            }
        rg4.setOnCheckedChangeListener { Radiogroup, checkedId ->

            when(checkedId){
                R.id.radio16 -> count +=2;
                R.id.radio17 -> count +=4;
                R.id.radio18 -> count +=6;
                R.id.radio19 -> count +=8;
                R.id.radio20 -> count +=10;


            }
    }

        nextpage.setOnClickListener {

            val intent = Intent(this,survey2::class.java)
            startActivity(intent);
        }
}}