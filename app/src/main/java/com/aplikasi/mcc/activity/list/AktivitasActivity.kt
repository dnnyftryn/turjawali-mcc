package com.aplikasi.mcc.activity.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplikasi.mcc.databinding.ActivityAktivitasBinding

class AktivitasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAktivitasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAktivitasBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}