package com.example.coba_api_indodax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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


        val queue = Volley.newRequestQueue(this)
        val url = "https://indodax.com/api/ticker/" + coin
        val jsonResponses: MutableList<String> = ArrayList()

        btnReq.setOnClickListener {
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    low.setText(response)
                },
                Response.ErrorListener { low.text = "That didn't work!" })
            queue.add(stringRequest)

//            volleyGet(url)

//            val jsonObjectRequest = JsonObjectRequest(
//                Request.Method.GET, url, null,
//                { response ->
//                    try {
//                        val jsonArray = response.getJSONArray("data")
//                        for (i in 0 until jsonArray.length()) {
//                            val jsonObject = jsonArray.getJSONObject(i)
//                            val last = jsonObject.getString("last")
//                            jsonResponses.add(last)
//                            low.text = "Response is: ${response}"
//                        }
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//                }) { error -> error.printStackTrace() }
//            queue.add(jsonObjectRequest)

        }
        fun volleyGet(url: String) {
            val jsonResponses: MutableList<String> = ArrayList()
            val requestQueue = Volley.newRequestQueue(this)
            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    try {
                        val jsonArray = response.getJSONArray("data")
                        for (i in 0 until jsonArray.length()) {
                            val jsonObject = jsonArray.getJSONObject(i)
                            val last = jsonObject.getString("last")
                            jsonResponses.add(last)
                            print(last.toString())
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }) { error -> error.printStackTrace() }
            requestQueue.add(jsonObjectRequest)
        }
    }
}