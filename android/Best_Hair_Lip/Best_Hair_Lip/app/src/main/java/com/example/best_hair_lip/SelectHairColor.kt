package com.example.best_hair_lip

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_select_hair_color.*
import kotlinx.android.synthetic.main.activity_select_lip_color.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.net.URL

class SelectHairColor : AppCompatActivity() {
    var new_name : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_hair_color)

        val intent: Intent = getIntent()
        new_name= intent.getStringExtra("url")
        //Toast.makeText(this@SelectHairColor, new_name, Toast.LENGTH_SHORT).show()

        var R = ""
        var G = ""
        var B = ""

        var send = SendImage("hair")
        val intent_next = Intent(this, Result::class.java)
        intent_next.putExtra("type", "hair")
        //색상 버튼
        natural_black.setOnClickListener {
            //사진이랑 문자열 서버로 전송하는 코드 (Json 파일로 전송해야)
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "43"
            G = "41"
            B = "41"

            send.send_image(R, G, B)
            //response.body().string()
        }

        neutral_blonde.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "169"
            G = "158"
            B = "125"
            send.send_image(R, G, B)

        }

        natural_red.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "158"
            G = "115"
            B = "98"
            send.send_image(R, G, B)
        }
        platinum.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "200"
            G = "207"
            B = "220"
            send.send_image(R, G, B)
        }
        furture_mist.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "142"
            G = "138"
            B = "126"
            send.send_image(R, G, B)
        }
        luminous_blonde.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "236"
            G = "202"
            B = "179"
            send.send_image(R, G, B)
        }
        misty_rose.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "223"
            G = "172"
            B = "184"
            send.send_image(R, G, B)
        }
        burgundy_blush.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "117"
            G = "76"
            B = "103"
            send.send_image(R, G, B)
        }
        vivacious_red.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "158"
            G = "71"
            B = "62"
            send.send_image(R, G, B)
        }
        mintcream_blonde.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "166"
            G = "205"
            B = "200"
            send.send_image(R, G, B)
        }
        dark_slate_gray.setOnClickListener {
            val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            startActivity(intent_next)
            R = "62"
            G = "81"
            B = "101"
            send.send_image(R, G, B)
        }
        darksea_green.setOnClickListener {
            //val intent_next = Intent(this, Result::class.java)
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("color", "darksea green")
            intent_next.putExtra("product_url", "https://www.kakaocorp.com/service/KakaoHairshop")
            startActivity(intent_next)
            R = "46"
            G = "83"
            B = "83"
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