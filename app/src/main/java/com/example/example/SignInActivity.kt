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

class SignInActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")

    //자동 로그인 기능
    private val signUpActivityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val id = data?.getStringExtra("ID")
                val pw = data?.getStringExtra("PW")
                //입력받은 회원가입 페이지 정보를 받음

                id?.let { editid.setText(it) }
                pw?.let { editpw.setText(it) }
            }
        }

    private lateinit var editid: EditText
    private lateinit var editpw: EditText

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val joinbtn = findViewById<Button>(R.id.JoinBtn)
        val loginbtn = findViewById<Button>(R.id.LoginBtn)
        editid = findViewById<EditText>(R.id.EditId)
        editpw = findViewById<EditText>(R.id.EditPw)

        loginbtn.setOnClickListener {
            val id = editid.text.toString()
            val pw = editpw.text.toString()

            //요구사항. id,pw 둘중 하나라도 공백일시 토스트 메시지만 출력
            if (id.isEmpty() || pw.isEmpty()){
                Toast.makeText(getApplicationContext(),"아이디/비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show();
            }else{
            Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_SHORT).show()
            var intent = Intent(this,HomeActivity::class.java)
                intent.putExtra("myid",id)
            startActivity(intent)}
            //둘다 있을 id를 HomeActivity 넘기고, 토스트 메시지를 출력하며 Activtiy 시작
        }

        //signUpActivity 이동 버튼
        joinbtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpActivityResult.launch(intent)
        }


    }

}