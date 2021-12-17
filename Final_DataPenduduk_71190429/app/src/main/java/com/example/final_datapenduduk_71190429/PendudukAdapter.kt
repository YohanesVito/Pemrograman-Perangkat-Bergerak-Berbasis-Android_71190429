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
            this.contact = contact
            v.findViewById<TextView>(R.id.tvName).text = contact.contactName
            v.findViewById<TextView>(R.id.tvNumber).text = contact.contactNumber
            v.findViewById<ImageView>(R.id.ivImage).setImageResource(contact.contactImage)

            v.setOnClickListener {
                //Toast.makeText(v.context, "${contact?.contactName} - ${contact?.contactNumber}", Toast.LENGTH_SHORT).show()
                val i = Intent(v.context, ContactDetail::class.java)
                i.putExtra("name",contact.contactName)
                i.putExtra("number",contact.contactNumber)
                i.putExtra("image",contact.contactImage)
                i.putExtra("email",contact.contactEmail)
                i.putExtra("address",contact.contactAddress)
                v.context.startActivity(i)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ContactHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactHolder(v)
    }
    //memilih file layout XML yang akan dijadikan container

    override fun onBindViewHolder(holder: ContactAdapter.ContactHolder, position: Int) {
        //memasang data ke dalam file layout XML yang telah dipilih
        holder.bindView(listContact[position])
    }

    override fun getItemCount(): Int {
        //mengembalikan jumlah item yang terdapat pada RecyclerView
        return listContact.size
    }
}
