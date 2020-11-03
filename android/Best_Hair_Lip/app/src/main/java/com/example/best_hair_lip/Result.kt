package com.example.best_hair_lip

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_get_picture.*
import kotlinx.android.synthetic.main.activity_result.*
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class Result : AppCompatActivity() {

    var bitmap: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val type : String = intent.getStringExtra("type")
        val color : String = intent.getStringExtra("color")
        val url : String = intent.getStringExtra("product_url")

        if(type == "hair"){
            textView.setText( color + "\n색으로 염색해보는 건 어떠세요?")
        }
        else if(type == "lip"){
            val product : String = intent.getStringExtra("product")
            textView.setText(color + " 색의 \n" + product+ " \n제품이 궁금하신가요?")
        }

        var i =0

        val uThread: Thread = object : Thread() {
                //네트워크 관련 작업할때 별도의 스레드 생성

                override fun run() {
                    val intent : Intent = getIntent()
                    val new_name: String = intent.getStringExtra("url")


                    while(true) {
                        try {
                                //서버에 올려둔 이미지 URL
                            val url = URL("http://117.16.43.105:8080/"+ new_name)
                            //Web에서 이미지 가져온 후 ImageView에 지정할 Bitmap 만들기

                            /* URLConnection 생성자가 protected로 선언되어 있으므로
                                                            개발자가 직접 HttpURLConnection 객체 생성 불가 */
                            val conn = url.openConnection() as HttpURLConnection
                            conn.doInput = true
                            //Server 통신에서 입력 가능한 상태로 만듦

                            conn.connect() //연결된 곳에 접속할 때 (connect() 호출해야 실제 통신 가능함)
                            /* openConnection()메서드가 리턴하는 urlConnection 객체는
                                                            HttpURLConnection의 인스턴스가 될 수 있으므로 캐스팅해서 사용한다*/


                            if(conn.getResponseCode() == 200)
                            {
                                val `is` = conn.inputStream //inputStream 값 가져오기
                                bitmap = BitmapFactory.decodeStream(`is`) // Bitmap으로 반환
                                break;
                            }

                            if(conn.getResponseCode() == 404)
                            {
                                sleep(1000)

                            }

                            } catch (e: MalformedURLException) {
                                sleep(1000)
                            } catch (e: IOException) {
                                sleep(1000)
                            }
                        }

                }
        }
        uThread.start() // 작업 Thread 실행
        try {
            //메인 Thread는 별도의 작업을 완료할 때까지 대기한다!
            //join() 호출하여 별도의 작업 Thread가 종료될 때까지 메인 Thread가 기다림
            //join() 메서드는 InterruptedException을 발생시킨다.
            uThread.join()
            //작업 Thread에서 이미지를 불러오는 작업을 완료한 뒤
            //UI 작업을 할 수 있는 메인 Thread에서 ImageView에 이미지 지정
            resultimage.setImageBitmap(bitmap)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        try_again.setOnClickListener{
            val intent_next = Intent(this, MainActivity::class.java)
            startActivity(intent_next)
        }

        buy.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url ))
            startActivity(intent)
        }


    }
}