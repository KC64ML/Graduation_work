package image11.graduation.ok.com.common

import android.app.Application
import image11.graduation.ok.com.R
import image11.graduation.ok.com.intercepter.TokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
//import com.kakao.sdk.common.KakaoSdk

class global : Application() {

    companion object {
        var BASE_URL = "http://3.36.62.198:8080/"

        lateinit var prefs: mySharedPreferences

        var retrofit: Retrofit? = null
        fun getBuilder(): Retrofit? {
            if (retrofit == null) {
                val client: OkHttpClient = OkHttpClient.Builder()
                    .readTimeout(10000, TimeUnit.MILLISECONDS)
                    .connectTimeout(10000, TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(TokenInterceptor()) // JWT 자동 헤더 전송
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return retrofit
        }

    }


    override fun onCreate() {
        super.onCreate()

        prefs = mySharedPreferences(applicationContext)

       // KakaoSdk.init(this, getString(R.string.kakao_app_key))
    }

}