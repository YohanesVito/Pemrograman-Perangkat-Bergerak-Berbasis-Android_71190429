package com.example.final_datapenduduk_71190429

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PendudukAdapter (val listPenduduk: ArrayList<Penduduk>): RecyclerView.Adapter<PendudukAdapter.PendudukHolder>(){
    class PendudukHolder(val v: View): RecyclerView.ViewHolder(v){
        var penduduk: Penduduk? = null

        fun bindView(penduduk: Penduduk){
            this.penduduk = penduduk
            v.findViewById<TextView>(R.id.tv_noKTP).text = penduduk.pendudukKTP
            v.findViewById<TextView>(R.id.tv_nama).text = penduduk.pendudukNama
            v.findViewById<TextView>(R.id.tv_noHP).text = penduduk.pendudukHP
            v.findViewById<TextView>(R.id.tv_alamat).text = penduduk.pendudukAlamat

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendudukAdapter.PendudukHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_penduduk, parent, false)
        return PendudukHolder(v)
    }
    //memilih file layout XML yang akan dijadikan container

    override fun onBindViewHolder(holder: PendudukAdapter.PendudukHolder, position: Int) {
        //memasang data ke dalam file layout XML yang telah dipilih
        holder.bindView(listPenduduk[position])
    }

    override fun getItemCount(): Int {
        //mengembalikan jumlah item yang terdapat pada RecyclerView
        return listPenduduk.size
    }
}
