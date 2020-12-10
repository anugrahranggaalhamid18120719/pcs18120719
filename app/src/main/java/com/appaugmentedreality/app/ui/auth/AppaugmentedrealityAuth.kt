package com.appaugmentedreality.app.ui.auth

import android.content.ComponentCallbacks
import android.content.Context
import com.appaugmentedreality.app.data.model.ActionState
import com.appaugmentedreality.app.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object AppaugmentedrealityAuth {
    fun logout(context: Context, callbacks: ((ActionState<Boolean>)-> Unit)? = null){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main){
                if(callbacks != null) callbacks.invoke(resp)
            }
        }
    }

}