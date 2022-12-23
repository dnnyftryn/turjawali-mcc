package com.aplikasi.mcc.activity.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplikasi.mcc.databinding.ActivitySiteBinding

class SiteActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySiteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySiteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.title = "Site"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}