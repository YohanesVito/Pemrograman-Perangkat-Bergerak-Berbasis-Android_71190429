package com.example.final_datapenduduk_71190429

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider

class MainActivity : AppCompatActivity() {

    private lateinit var loginEmail: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

       loginEmail = FirebaseAuth.getInstance()

        val username = findViewById<EditText>(R.id.et_username)
        val password = findViewById<EditText>(R.id.et_password)
        val btnSubmit = findViewById<Button>(R.id.bt_submit)
        val btnLogin = findViewById<Button>(R.id.bt_loginEmail)

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
                Toast.makeText(this,"Wrong Password, Hint: 1234", Toast.LENGTH_SHORT).show()
            }
        }

        btnLogin.setOnClickListener{
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                username.text.toString(),
                password.text.toString())
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(this,"Berhasil Login Email", Toast.LENGTH_SHORT).show()
                        val i = Intent(this, SecondActivity::class.java);
                        i.putExtra("username", username.text.toString())
                        i.putExtra("password", password.text.toString())
                        startActivity(i)
                    }
                    else{
                        Toast.makeText(this,"Gagal Login Email", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}