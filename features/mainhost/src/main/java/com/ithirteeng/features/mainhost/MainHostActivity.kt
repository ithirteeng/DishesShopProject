package com.ithirteeng.features.mainhost

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.ithirteeng.features.mainhost.databinding.ActivityMainHostBinding

class MainHostActivity : AppCompatActivity() {

    companion object {
        fun provideScreen() = ActivityScreen { Intent(it, MainHostActivity::class.java) }
    }

    private val binding by lazy {
        ActivityMainHostBinding.inflate(this.layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}