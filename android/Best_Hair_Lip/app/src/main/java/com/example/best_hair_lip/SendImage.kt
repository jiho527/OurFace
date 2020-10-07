package com.example.best_hair_lip

import android.content.Intent
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.net.URL

class SendImage constructor(type : String){

    var Type: String = type
    fun send_image(R: String, G: String, B: String){

        //url
        val url = URL("http://117.16.43.105:8080/json")

        val JSON = MediaType.parse("application/json; charset=utf-8")
        val client = OkHttpClient()
        val json = JSONObject()
        //val strYes = String(byteArray)
        //charset=utf-8
        json.put("type", Type)
        json.put("ColorCode_R", R)
        json.put("ColorCode_G", G)
        json.put("ColorCode_B", B)

        val body = RequestBody.create(JSON, json.toString())
        val request: Request = Request.Builder().url(url).post(body).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {

            }
            @Throws(IOException::class)
            override fun onResponse(call: Call?, response: Response?) {
            }
        })
    }

}