package com.appaugmentedreality.app.data.repository

import com.appaugmentedreality.app.data.model.ActionState
import com.appaugmentedreality.app.data.model.Forum
import com.appaugmentedreality.app.data.remote.ForumService
import com.appaugmentedreality.app.data.remote.RetrofitApi
import com.appaugmentedreality.app.data.remote.RetrofitApi.instance
import retrofit2.Retrofit
import retrofit2.await
import java.lang.Exception

class ForumRepository {
    private val instance: ForumService by lazy { RetrofitApi.instance }

    suspend fun listForum() : ActionState<ArrayList<Forum>>{
      return  try {
            val list = instance.listForum() .await()
            ActionState(list.<ArrayList<Forum>>)

        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
}

p
