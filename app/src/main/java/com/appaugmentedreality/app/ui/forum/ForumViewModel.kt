package com.appaugmentedreality.app.ui.forum

import android.app.DownloadManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appaugmentedreality.app.data.model.ActionState
import com.appaugmentedreality.app.data.model.Forum
import com.appaugmentedreality.app.data.repository.ForumRepository
import kotlinx.coroutines.launch

class ForumViewModel : ViewModel() {
   private val repo: ForumRepository by lazy { ForumRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Forum>>()
    val detailResp = MutableLiveData<Forum>()
    val searchRep = MutableLiveData<List<Forum>>()

    val url = MutableLiveData("")

    fun listForum(){
        viewModelScope.launch {
            loading.value = true
                val resp = repo.listForum()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailForum(url: String? = this.url.value){
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailForum(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchForum(query: String? = this.query.value){
        query?.let{
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchForum(it)
                actionState.value = resp
                searchRep.value = resp.data
                loading.value = false
            }
        }
    }
}