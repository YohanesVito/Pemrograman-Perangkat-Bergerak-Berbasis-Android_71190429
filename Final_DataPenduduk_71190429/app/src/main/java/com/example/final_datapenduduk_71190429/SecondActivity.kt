package com.example.final_datapenduduk_71190429

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val username = getIntent().getStringExtra("username")
        val password = getIntent().getStringExtra("password")

        val message = findViewById<TextView>(R.id.welcomeText)
        message.text = "Welcome ${username}, your password is ${password}"

        val btnlihatdata = findViewById<Button>(R.id.bt_lihatdata)
        val btntambahdata = findViewById<Button>(R.id.bt_tambahdata)
        val btnlogout = findViewById<Button>(R.id.bt_logout)

        btnlihatdata.setOnClickListener {
            val i = Intent(this, LihatDataPenduduk::class.java);
            startActivity(i)
        }

        btntambahdata.setOnClickListener {
            val i = Intent(this, TambahDataPenduduk::class.java);
            startActivity(i)
        }

        btnlogout.setOnClickListener {
            Toast.makeText(this,"Log Out Berhasil!", Toast.LENGTH_SHORT).show()
            val i = Intent(this, MainActivity::class.java);
            startActivity(i)
        }
    }

}