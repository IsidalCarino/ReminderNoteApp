package com.example.assessment2utilityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
                val intent = Intent(this@SplashScreenActivity, DetailsActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}