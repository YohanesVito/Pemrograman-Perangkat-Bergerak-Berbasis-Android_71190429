package com.example.coba_api_indodax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import com.android.volley.VolleyError

import org.json.JSONException

import org.json.JSONArray

import com.android.volley.RequestQueue




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coin = findViewById<EditText>(R.id.etCoin)

        val namaCoin = findViewById<TextView>(R.id.tvHasil)
        val low = findViewById<TextView>(R.id.tvLow)
        val high = findViewById<TextView>(R.id.tvHigh)
        val last = findViewById<TextView>(R.id.tvLast)

        val btnReq = findViewById<Button>(R.id.btnReq)

        btnReq.setOnClickListener {
            namaCoin.setText(coin.text.toString().uppercase())
            val url = "https://indodax.com/api/ticker/${coin.text.toString().lowercase()}"
            coin.setText("")
            val queue = Volley.newRequestQueue(this)

            val request = JsonObjectRequest(Request.Method.GET,url,null,
                { it ->
                    try {
                        val ticker = JSONObject(it["ticker"].toString())

                        val vlast= ticker["last"]
                        val vhigh= ticker["high"]
                        val vlow = ticker["low"]

                        last.setText(vlast.toString())
                        low.setText(vlow.toString())
                        high.setText(vhigh.toString())
                    }
                    catch(e: Exception){
                        Toast.makeText(this,"Koin pair tidak ditemukan, ${e.message}",Toast.LENGTH_SHORT).show()
                        coin.setText("")
                        last.setText("")
                        low.setText("")
                        high.setText("")
                    }

                }, {
                    Toast.makeText(this,"Koin tidak ditemukan",Toast.LENGTH_SHORT).show()
                    Log.e("error","error")
                })
            queue.add(request)
//            downloadTask()
        }
    }
//    fun downloadTask(){
//        val url = "https://indodax.com/api/ticker/"
//        val queue = Volley.newRequestQueue(this)
//        val request = StringRequest(
//            Request.Method.GET,url,
//            Response.Listener{ response ->
//                Log.e("Berhasil",response.toString())
//            },
//            Response.ErrorListener {
//
//            })
//        queue.add(request)
//    }
}