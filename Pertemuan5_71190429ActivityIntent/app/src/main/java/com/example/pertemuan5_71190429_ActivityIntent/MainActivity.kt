package com.example.pertemuan5_71190429_ActivityIntent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pertemuan5_71190429_ActivityIntent.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.et_username)
        val password = findViewById<EditText>(R.id.et_password)
        val btnSubmit = findViewById<Button>(R.id.bt_submit)

        btnSubmit.setOnClickListener {
            val name = username.text.toString()
            val pw = password.text.toString()
            if(pw == "1234"){
                val i = Intent(this, SecondActivity::class.java);
                i.putExtra("username", name.toString())
                i.putExtra("password", pw.toString())
                startActivity(i)
            }
            else{
                Toast.makeText(this,"Wrong Password, Hint: 1234",Toast.LENGTH_SHORT).show()
            }
        }
    }
}