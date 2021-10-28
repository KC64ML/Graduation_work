package com.example.re_grud.MemoryGame


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.re_grud.R
import java.text.FieldPosition


private  const val TAG = "Memory"
private lateinit var buttons: List<ImageButton>
private lateinit var cards: List<Memorycard>
private  var indexoutofSelectedCard: Int ? =null
class Memory: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.memorygame)

        val im1 = findViewById<ImageButton>(R.id.im1)
        val im2 = findViewById<ImageButton>(R.id.im2)
        val im3 = findViewById<ImageButton>(R.id.im3)
        val im4 = findViewById<ImageButton>(R.id.im4)
        val im5 = findViewById<ImageButton>(R.id.im5)
        val im6 = findViewById<ImageButton>(R.id.im6)
        val im7 = findViewById<ImageButton>(R.id.im7)
        val im8 = findViewById<ImageButton>(R.id.im8)

        val images = mutableListOf(R.drawable.bus,R.drawable.cake,R.drawable.circle,R.drawable.flash)
        images.addAll(images)
        //이미지 랜덤화
        images.shuffle()

        buttons = listOf(im1,im2,im3,im4,im5,im6,im7,im8)

        cards =  buttons.indices.map { index->
            Memorycard(images[index])
        }

        buttons.forEachIndexed {
                index, button ->
            button.setOnClickListener {
                Log.i(TAG,"button Clicked!@")
                updateModels(index)
                updateViews()


            }

        }




    }
    private fun updateViews()
    {
        cards.forEachIndexed {
                index, card ->
            val button = buttons[index]
            if (card.isFaceup)
            {
                button.setImageResource(card.identifier)
            }
            else
            {
                button.setImageResource(R.drawable.code)
            }
        }

    }
    private fun updateModels(position: Int)
    {
        val card = cards[position]

        if(card.isFaceup)
        {
            Toast.makeText(this,"invalid",Toast.LENGTH_SHORT).show()
        }
        if(indexoutofSelectedCard == null)
        {
            indexoutofSelectedCard = position
            restorCards()

        }else
        {
            checkForMatch(indexoutofSelectedCard!!,position)
            indexoutofSelectedCard = null

        }
        card.isFaceup= !card.isFaceup

    }
    private fun restorCards()
    {
        for (card in cards)
        {
            if (!card.isMathed)
            {
                card.isFaceup = false

            }

        }

    }
    private fun checkForMatch(position: Int ,position2: Int)
    {
        if(cards[position].identifier == cards[position2].identifier)
        {
            Toast.makeText(this,"성공^^ ",Toast.LENGTH_SHORT).show()
            cards[position].isMathed = true
            cards[position2].isMathed = true

        }

    }


}

