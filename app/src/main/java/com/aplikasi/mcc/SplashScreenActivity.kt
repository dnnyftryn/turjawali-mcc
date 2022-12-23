package com.aplikasi.mcc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Base64
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.aplikasi.mcc.activity.LoginActivity
import com.aplikasi.mcc.api.RetrofitClient
import com.aplikasi.mcc.data.BackgroundResponse
import com.aplikasi.mcc.databinding.ActivitySplashScreenBinding
import com.aplikasi.mcc.pref.LoginData
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var pref: LoginData

    companion object {
        private const val SPLASH_SCREEN_TIME = 4000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        pref = LoginData(this)


        Handler(Looper.getMainLooper()).postDelayed({
            if (pref.getBackground() != null) {
                Log.d("SPLASH", "onResponse: ${pref.getBackground()}")
                if (pref.getLogin()) {
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                Glide
                    .with(this)
                    .asDrawable()
                    .load(pref.getBackground())
                    .into(binding.ivLogo)
                Log.d("SPLASH", "onResponse: Trus")
            } else {
                Glide
                    .with(this)
                    .asDrawable()
                    .load(R.drawable.ic_logo)
                    .into(binding.ivLogo)
                Log.d("SPLASH", "onResponse: Else")

            }
            finish()
        }, SPLASH_SCREEN_TIME)

    }


}