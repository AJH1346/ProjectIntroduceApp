package com.example.example

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class SignUpActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val upname = findViewById<EditText>(R.id.upName)
        val upid = findViewById<EditText>(R.id.upId)
        val uppw = findViewById<EditText>(R.id.upPw)
        val btn = findViewById<Button>(R.id.SignInBtn)

        btn.setOnClickListener {
            val name = upname.text.toString()
            val id = upid.text.toString()
            val pw = uppw.text.toString()

            //요구사항 하나라도 공백일시 토스트 메시지 출력
            if(name.isEmpty() || id.isEmpty() || pw.isEmpty()){
                Toast.makeText(getApplicationContext(),"입력되지 않은 정보가 있습니다.",Toast.LENGTH_SHORT).show()
            } else{
                val intent = Intent()
                intent.putExtra("ID", id)
                intent.putExtra("PW", pw)
                setResult(Activity.RESULT_OK, intent)
                finish()
                //전부 입력시 signInActicty로 정보 넘겨주고, 이동
            }
        }
    }
}