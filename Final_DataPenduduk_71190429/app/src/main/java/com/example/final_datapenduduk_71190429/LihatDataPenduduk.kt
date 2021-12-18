package com.example.final_datapenduduk_71190429

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class LihatDataPenduduk: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihatdatapenduduk)
        
        //ambil data dari firestore
        val listPenduduk = ArrayList<Penduduk>()
        listPenduduk.add(Penduduk("340401231241", "Yohanes Vito Rizki", "08224124124", "Jalan Kanthil"))
        listPenduduk.add(Penduduk("330401231241", "Raden Mas Pono Noto Boto Sedoso", "0899955555123", "Jalan Kenanga"))

//        val penduduk = Penduduk(P.text.toString(), nim.text.toString(), ipk.text.toString())
//
//        firestore.collection("Mahasiswa").whereEqualTo("nama", nama.text.toString()).get().addOnSuccessListener {
//                hasilPencarian->
//            for (hasil in hasilPencarian){
//                hasilNama.setText("${hasil.data["nama"]}")
//                hasilNIM.setText("${hasil.data["nim"]}")
//                hasilIPK.setText("${hasil.data["ipk"]}")
//            }
//        }

        //siapkan RecyclerView
        val rvPenduduk = findViewById<RecyclerView>(R.id.rvListPenduduk)
        rvPenduduk.layoutManager = LinearLayoutManager (this)
        val adapter = PendudukAdapter(listPenduduk)
        rvPenduduk.adapter = adapter
    }
}