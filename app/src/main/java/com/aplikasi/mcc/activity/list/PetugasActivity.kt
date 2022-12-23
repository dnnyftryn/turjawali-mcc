package com.aplikasi.mcc.activity.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplikasi.mcc.databinding.ActivityPetugasBinding

class PetugasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPetugasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetugasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.title = "Petugas"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}