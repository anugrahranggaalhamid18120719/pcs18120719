package com.appaugmentedreality.app.ui.forum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appaugmentedreality.app.R

class ForumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)
    }
    companion object{
        const val OPEN_FORUM = "open_forum"
    }
}