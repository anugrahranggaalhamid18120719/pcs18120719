package com.appaugmentedreality.app.data.remote

import com.appaugmentedreality.app.data.model.Forum
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit
import kotlin.contracts.ReturnsNotNull

object RetrofitApi {


    const val FORUM_URL = "https://dekontaminasi.com/api/id/covid19/hospitals"

    val instance: Forum by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(FORUM_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(Forum::class.java)

    }
   /* private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build()

    private fun create(url: String) : Retrofit{
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
    fun forumService() : ForumService {
        return create(FORUM_URL).create(ForumService::class.java)
    }*/
}