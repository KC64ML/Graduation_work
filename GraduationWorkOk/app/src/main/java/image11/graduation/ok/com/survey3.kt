package image11.graduation.ok.com

import android.os.Bundle
import android.telephony.RadioAccessSpecifier
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.sulmun1.*
import kotlinx.android.synthetic.main.sulmun3.*
import org.jetbrains.anko.find

class survey3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sulmun3)
        var count = 0;

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
                R.id.radio46-> count += 2;
                R.id.radio47 -> count += 4;
                R.id.radio48 -> count += 6;
                R.id.radio49 -> count += 8;
                R.id.radio50 -> count += 10;


            }






        }
    }}