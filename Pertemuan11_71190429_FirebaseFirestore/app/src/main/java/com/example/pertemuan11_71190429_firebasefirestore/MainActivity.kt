package com.example.pertemuan11_71190429_firebasefirestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    var firestore: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nama = findViewById<EditText>(R.id.etNama)
        val nim = findViewById<EditText>(R.id.etNIM)
        val ipk = findViewById<EditText>(R.id.etIPK)

        val btnsimpan = findViewById<Button>(R.id.btnSimpan)
        val btncari = findViewById<Button>(R.id.btnCari)

        val hasilNama = findViewById<TextView>(R.id.tvHasilNama)
        val hasilNIM = findViewById<TextView>(R.id.tvHasilNIM)
        val hasilIPK = findViewById<TextView>(R.id.tvHasilIPK)


        firestore = FirebaseFirestore.getInstance()

    }




}