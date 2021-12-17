package com.example.final_datapenduduk_71190429

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val username = getIntent().getStringExtra("username")
        val password = getIntent().getStringExtra("password")

        val message = findViewById<TextView>(R.id.welcomeText)
        message.text = "Welcome ${username}, your password is ${password}"

    }

}