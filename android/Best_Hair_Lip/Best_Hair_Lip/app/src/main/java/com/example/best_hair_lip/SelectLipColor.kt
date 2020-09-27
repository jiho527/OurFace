package com.example.best_hair_lip

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_select_lip_color.*
import okhttp3.*
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class SelectLipColor : AppCompatActivity() {

    var new_name : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_lip_color)


        val intent: Intent = getIntent()
        new_name= intent.getStringExtra("url")
        //Toast.makeText(this@SelectLipColor, new_name, Toast.LENGTH_SHORT).show()

        val intent_next = Intent(this, Result::class.java)
        intent_next.putExtra("type", "lip")
        var R = ""
        var G = ""
        var B = ""

        var send = SendImage("lip")

        //색상 버튼
        LadyDanger.setOnClickListener {
            //사진이랑 문자열 서버로 전송하는 코드 (Json 파일로 전송해야)
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "237"
            G = "38"
            B = "0"

            send.send_image(R, G, B)
            //response.body().string()
        }

        RelentlesslyRed.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "246"
            G = "17"
            B = "67"
            send.send_image(R, G, B)

        }

        SpotlightMe.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "246"
            G = "139"
            B = "129"
            send.send_image(R, G, B)
        }
        CascadeBordo.setOnClickListener {
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "입생로랑 베르니 아 레브르 워터 스테인")
            intent_next.putExtra("color", "캐스케이드 보르도")
            intent_next.putExtra("product_url", "https://www.yslbeautykr.com/ko_KR/makeup/lip/vernis_a_levres_water_stain/WW-50357YSL.html")
            startActivity(intent_next)
            R = "130"
            G = "7"
            B = "54"
            send.send_image(R, G, B)
        }
        WetBemilion.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "228"
            G = "13"
            B = "11"
            send.send_image(R, G, B)
        }
        NedeEmblum.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "212"
            G = "77"
            B = "81"
            send.send_image(R, G, B)
        }
        Amur.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "205"
            G = "39"
            B = "51"
            send.send_image(R, G, B)
        }
        Arthor.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "233"
            G = "31"
            B = "24"
            send.send_image(R, G, B)
        }
        rebele.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "224"
            G = "4"
            B = "32"
            send.send_image(R, G, B)
        }
        red.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "190"
            G = "3"
            B = "14"
            send.send_image(R, G, B)
        }
        BDior.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "204"
            G = "36"
            B = "86"
            send.send_image(R, G, B)
        }
        ivispink.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "231"
            G = "46"
            B = "67"
            send.send_image(R, G, B)
        }

    }
        /*fun send_image(R: String, G: String, B: String){


            //url
            val url = URL("http://117.16.44.14:8080/json")

            val JSON = MediaType.parse("application/json; charset=utf-8")
            val client = OkHttpClient()
            val json = JSONObject()
            //val strYes = String(byteArray)
            //charset=utf-8
            json.put("type", "Lip")
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


    }*/



}
