package com.aplikasi.mcc.activity.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplikasi.mcc.databinding.ActivityAtensiBinding

class AtensiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAtensiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtensiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}