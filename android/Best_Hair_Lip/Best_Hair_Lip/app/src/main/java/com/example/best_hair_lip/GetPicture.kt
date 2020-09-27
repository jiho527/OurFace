package com.example.best_hair_lip

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_get_picture.*
import okhttp3.*
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class GetPicture : AppCompatActivity() {
    private val OPEN_GALLERY = 1
    var bitmap: Bitmap? = null
    var new_name : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_picture)


        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, 1)

        //setContentView(R.layout.activity_get_picture)
        //openGallery()

        Lip_color_button.setOnClickListener {
            val intent = Intent(this, SelectLipColor::class.java)
            intent.putExtra("url", new_name)
            startActivity(intent)
        }
        Hair_color_button.setOnClickListener {
            val intent = Intent(this, SelectHairColor::class.java)
            intent.putExtra("url", new_name)
            startActivity(intent)
        }
    }

    private fun openGallery()
    {
        val photoPickerIntent = Intent(Intent.ACTION_PICK)
        photoPickerIntent.type = "image/*"
        startActivityForResult(photoPickerIntent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === 1) {
            // Make sure the request was successful
            if (resultCode === Activity.RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    val In: InputStream? = contentResolver.openInputStream(data!!.data!!)
                    bitmap = BitmapFactory.decodeStream(In)
                    if (In != null) {
                        In.close()
                    }
                    // 이미지 표시
                    getImage.setImageBitmap(bitmap)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val byteArray= stream.toByteArray()
        val encodedImage = Base64.encode(byteArray, Base64.DEFAULT)
        // val encodedImage = Base64.encode(byteArray, Base64.DEFAULT)
        val url: String = "http://117.16.43.105:8080"


        //requestbody
        val postBodyImage: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart(
                "image",
                "androidFlask.jpg",
                RequestBody.create(MediaType.parse("image/*jpg"), byteArray)
            )
            .build()

        postRequest(url, postBodyImage)

    }

    fun postRequest(postUrl: String?, postBody: RequestBody?) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(postUrl)
            .post(postBody)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // Cancel the post on failure.
                call.cancel()

                // In order to access the TextView inside the UI thread, the code is executed inside runOnUiThread()
                runOnUiThread {
                    val responseText = findViewById<TextView>(R.id.responseText)
                    responseText.text = "Failed to Connect to Server"
                }
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                // In order to access the TextView inside the UI thread, the code is executed inside runOnUiThread()
                runOnUiThread {
                    val responseText = findViewById<TextView>(R.id.responseText)
                    try {
                        responseText.text = response.body().string()
                        new_name = responseText.text.toString()
                        //Toast.makeText(this@GetPicture, new_name , Toast.LENGTH_SHORT).show()

                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        })
    }
    /* if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLERY)
            {
                //currentImageUrl 현재 선택한 사진
                var currentImageUrl : Uri? = data?.data


                //bitmap에 사진이 bitmap형식으로 저장되어 있음
                bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, currentImageUrl)

                try{
                    //이미지 불러와서 띄우기
                    getImage.setImageBitmap(bitmap)

                    //Json 파일에 이미지 base_64로 변환해서 저장
                    //Data model


                }catch(e: Exception){
                    e.printStackTrace()
                }catch (e: FileNotFoundException) {
                    // TODO Auto-generated catch block
                    e.printStackTrace()
                }

            }
        }*/
    /*val uThread: Thread = object : Thread() {
                            //네트워크 관련 작업할때 별도의 스레드 생성
                            override fun run() {
                                try {
                                    //서버에 올려둔 이미지 URL
                                    val url =
                                        URL("http://117.16.44.14:8080/static/116_2.png")
                                    //Web에서 이미지 가져온 후 ImageView에 지정할 Bitmap 만들기

                                    /* URLConnection 생성자가 protected로 선언되어 있으므로
                                                                    개발자가 직접 HttpURLConnection 객체 생성 불가 */
                                    val conn =
                                        url.openConnection() as HttpURLConnection
                                    /* openConnection()메서드가 리턴하는 urlConnection 객체는
                                                                    HttpURLConnection의 인스턴스가 될 수 있으므로 캐스팅해서 사용한다*/conn.doInput =
                                        true //Server 통신에서 입력 가능한 상태로 만듦
                                    conn.connect() //연결된 곳에 접속할 때 (connect() 호출해야 실제 통신 가능함)
                                    val `is` =
                                        conn.inputStream //inputStream 값 가져오기
                                    bitmap = BitmapFactory.decodeStream(`is`) // Bitmap으로 반환
                                } catch (e: MalformedURLException) {
                                    e.printStackTrace()
                                } catch (e: IOException) {
                                    e.printStackTrace()
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
                            imageView.setImageBitmap(bitmap)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }*/
}
