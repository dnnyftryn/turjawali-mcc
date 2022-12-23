package com.aplikasi.mcc.activity.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplikasi.mcc.databinding.ActivityPatroliBinding

class PatroliActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPatroliBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatroliBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}