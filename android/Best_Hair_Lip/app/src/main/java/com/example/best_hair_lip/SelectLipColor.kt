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
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "맥 매트 립스틱")
            intent_next.putExtra("color", "레이디데인져")
            intent_next.putExtra("product_url", "https://www.maccosmetics.co.kr/product/13854/310/makeup/matte-lipsticklipstick/matte-lipstick")
            startActivity(intent_next)
            R = "237"
            G = "38"
            B = "0"

            send.send_image(R, G, B)
            //response.body().string()
        }

        RelentlesslyRed.setOnClickListener {
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "맥 레트로 매트 립스틱")
            intent_next.putExtra("color", "릴렌트리슬리 레드")
            intent_next.putExtra("product_url", "https://www.maccosmetics.co.kr/product/13854/52593/makeup/retro-matte-lipstickck/retro-matte-lipstick#!/shade/%EB%A6%B4%EB%A0%8C%ED%8A%B8%EB%A6%AC%EC%8A%AC%EB%A6%AC_%EB%A0%88%EB%93%9C")
            startActivity(intent_next)
            R = "246"
            G = "17"
            B = "67"
            send.send_image(R, G, B)

        }

        SpotlightMe.setOnClickListener {
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "맥 러스터 립스틱")
            intent_next.putExtra("color", "스포트라이트 미")
            intent_next.putExtra("product_url", "https://www.maccosmetics.co.kr/product/13854/52598/makeup/amplified-lipstick#!/shade/%EC%8A%A4%ED%8F%AC%ED%8A%B8%EB%9D%BC%EC%9D%B4%ED%8A%B8_%EB%AF%B8_")
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
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "입생로랑 베르니 아 레브르 워터 스테인")
            intent_next.putExtra("color", "웻 베밀리온")
            intent_next.putExtra("product_url", "https://www.yslbeautykr.com/ko_KR/makeup/lip/vernis_a_levres_water_stain/WW-50357YSL.html")
            startActivity(intent_next)
            R = "228"
            G = "13"
            B = "11"
            send.send_image(R, G, B)
        }
        NedeEmblum.setOnClickListener {
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "입생로랑 따뚜아쥬 꾸뛰르 벨벳 틴트")
            intent_next.putExtra("color", "누드 엠블럼")
            intent_next.putExtra("product_url", "https://www.yslbeautykr.com/ko_KR/makeup/lip/tatouage_couture/WW-50582YSL.html#q=%EB%94%B0%EB%9A%9C%EC%95%84%EC%A5%AC+%EA%BE%B8%EB%9B%B0%EB%A5%B4&start=2")
            startActivity(intent_next)
            R = "212"
            G = "77"
            B = "81"
            send.send_image(R, G, B)
        }
        Amur.setOnClickListener {
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "샤넬 루쥬 코코 플래쉬 ")
            intent_next.putExtra("color", "아무르")
            intent_next.putExtra("product_url", "https://www.chanel.com/ko_KR/fragrance-beauty/makeup/p/lips/lipsticks/rouge-coco-flash-colour-shine-intensity-in-a-flash-p174052.html#skuid-0174092")
            startActivity(intent_next)
            R = "205"
            G = "39"
            B = "51"
            send.send_image(R, G, B)
        }
        Arthor.setOnClickListener {
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "샤넬 루쥬 코코")
            intent_next.putExtra("color", "아서")
            intent_next.putExtra("product_url", "https://www.chanel.com/ko_KR/fragrance-beauty/makeup/p/lips/lipsticks/rouge-coco-ultra-hydrating-lip-colour-p172400.html#skuid-0172416")
            startActivity(intent_next)
            R = "233"
            G = "31"
            B = "24"
            send.send_image(R, G, B)
        }
        rebele.setOnClickListener {
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "샤넬 루쥬 알뤼르 잉크")
            intent_next.putExtra("color", "리베레")
            intent_next.putExtra("product_url", "https://www.chanel.com/ko_KR/fragrance-beauty/makeup/p/lips/liquid-lipsticks/rouge-allure-ink-matte-liquid-lip-colour-p165140.html#skuid-0165148")
            startActivity(intent_next)
            R = "224"
            G = "4"
            B = "32"
            send.send_image(R, G, B)
        }
        red.setOnClickListener {
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "루즈 디올")
            intent_next.putExtra("color", "레드")
            intent_next.putExtra("product_url", "https://www.dior.com/ko_kr/products/beauty-Y0027830-%EB%A3%A8%EC%A6%88-%EB%94%94%EC%98%AC-%EA%BE%B8%EB%9B%B0%EB%A5%B4-%EC%BB%AC%EB%9F%AC-%EC%82%AC%ED%8B%B4%EC%97%90%EC%84%9C-%EB%A7%A4%ED%8A%B8%EA%B9%8C%EC%A7%80-%EC%BB%B4%ED%8F%AC%ED%8A%B8-%EC%9B%A8%EC%96%B4?objectID=Y0027830&query=%EB%A3%A8%EC%A6%88%20%EB%94%94%EC%98%AC&queryID=c21cd974535b34c0b835d6139d988765")
            startActivity(intent_next)
            R = "190"
            G = "3"
            B = "14"
            send.send_image(R, G, B)
        }
        BDior.setOnClickListener {
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "디올 어딕트 스텔라 샤인")
            intent_next.putExtra("color", "비 디올")
            intent_next.putExtra("product_url", "https://www.dior.com/ko_kr/products/beauty-Y0048000-%EB%94%94%EC%98%AC-%EC%96%B4%EB%94%95%ED%8A%B8-%EC%8A%A4%ED%85%94%EB%9D%BC-%EC%83%A4%EC%9D%B8-%EC%83%9D%EA%B8%B0-%EB%84%98%EC%B9%98%EB%8A%94-%EC%BB%AC%EB%9F%AC%EC%99%80-%EB%88%88%EB%B6%80%EC%8B%A0-%EB%B0%98%EC%A7%9D%EC%9E%84%EC%9D%84-%EC%84%A0%EC%82%AC%ED%95%98%EB%8A%94-%EC%8A%A4%ED%85%94%EB%9D%BC-%EC%83%A4%EC%9D%B8-%EB%A6%BD%EC%8A%A4%ED%8B%B1?objectID=Y0048000&query=%EC%8A%A4%ED%85%94&queryID=8dae7b52dec78c47cea8c4eae873c508")
            startActivity(intent_next)
            R = "204"
            G = "36"
            B = "86"
            send.send_image(R, G, B)
        }
        ivispink.setOnClickListener {
            intent_next.putExtra("url", new_name)
            intent_next.putExtra("product", "디올 어딕트 스텔라 샤인")
            intent_next.putExtra("color", "이비스 핑크")
            intent_next.putExtra("product_url", "https://www.dior.com/ko_kr/products/beauty-Y0048004-%EB%94%94%EC%98%AC-%EC%96%B4%EB%94%95%ED%8A%B8-%EC%8A%A4%ED%85%94%EB%9D%BC-%EC%83%A4%EC%9D%B8-%EC%BB%AC%EB%9F%AC-%EA%B2%8C%EC%9E%84-%EC%BB%AC%EB%A0%89%EC%85%98-%EB%A6%AC%EB%AF%B8%ED%8B%B0%EB%93%9C-%EC%97%90%EB%94%94%EC%85%98-%EB%A6%BD-%EC%83%A4%EC%9D%B8-%EC%83%9D%EA%B8%B0-%EB%84%98%EC%B9%98%EB%8A%94-%EC%BB%AC%EB%9F%AC-%EA%B0%90%EB%AF%B8%EB%A1%9C%EC%9A%B4-%ED%95%98%EC%9D%B4%EB%93%9C%EB%A0%88%EC%9D%B4%ED%8C%85-%EC%BC%80%EC%96%B4?objectID=Y0048004&query=%EC%96%B4%EB%94%95%ED%8A%B8%20%EC%8A%A4&queryID=af23fc02aa86c9ce0266ae341fbb8d2a")
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
