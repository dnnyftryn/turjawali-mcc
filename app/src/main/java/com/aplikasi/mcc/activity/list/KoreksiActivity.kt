package com.aplikasi.mcc.activity.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplikasi.mcc.databinding.ActivityKoreksiBinding

class KoreksiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKoreksiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKoreksiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}