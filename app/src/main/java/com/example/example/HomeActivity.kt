package com.example.example

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val mynameView =findViewById<TextView>(R.id.idView)
        val myname = intent.getStringExtra("myid")
        val image = findViewById<ImageView>(R.id.imageView)
        //이미지 담은 배열 생성
        val imageArray = arrayOf(
            R.drawable.soccer1,
            R.drawable.soccer2,
            R.drawable.soccer3,
            R.drawable.soccer4,
            R.drawable.soccer5
        )

        //배열 인덱스 랜덤으로 출력
        val randomIndex = Random.nextInt(imageArray.size)
        image.setImageResource(imageArray[randomIndex])

        mynameView.text = "아이디: $myname"

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            finish()
        }
    }
}