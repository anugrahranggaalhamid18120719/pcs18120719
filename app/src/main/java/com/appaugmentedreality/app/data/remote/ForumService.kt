package com.appaugmentedreality.app.data.remote



import com.appaugmentedreality.app.data.model.Forum
import retrofit2.Call
import retrofit2.http.GET


interface ForumService {
    @GET("/")
    fun listForum(): Call<ArrayList<Forum>>

}