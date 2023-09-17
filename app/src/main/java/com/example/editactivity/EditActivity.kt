package com.example.editactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.editactivity.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.landish
    private var imageIdList = listOf(
        R.drawable.landish,
        R.drawable.vasilek,
        R.drawable.romashka,
        R.drawable.rose,
        R.drawable.narcis,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        binding.im.setImageResource(R.drawable.landish)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() {
        binding.apply {
        bNext.setOnClickListener {
            indexImage++
            if (indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            im.setImageResource(imageId)
            }
        bDone.setOnClickListener {
            val plant = Plant(imageId, edTitle.text.toString(), edDisc.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
            }
        }
    }

}