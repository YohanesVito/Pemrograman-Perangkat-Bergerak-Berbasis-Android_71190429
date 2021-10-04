package com.example.pertemuan4_71190429_loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.Pertemuan4_71190429LoginApp.R

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val username = getIntent().getExtra("username")
        val password = getIntent().getExtra("password")
    }

}