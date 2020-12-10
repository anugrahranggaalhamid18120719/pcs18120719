package com.appaugmentedreality.app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appaugmentedreality.app.R
import com.appaugmentedreality.app.databinding.ActivityAuthBinding
import com.appaugmentedreality.app.databinding.ActivityMainBinding
import com.appaugmentedreality.app.ui.auth.AppaugmentedrealityAuth
import com.appaugmentedreality.app.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            AppaugmentedrealityAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}