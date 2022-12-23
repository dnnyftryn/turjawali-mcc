package com.aplikasi.mcc.activity.detail

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aplikasi.mcc.databinding.ActivityGetDetailImageBinding
import com.bumptech.glide.Glide

class GetDetailImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetDetailImageBinding

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetDetailImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.title = "Detail Gambar"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.extras
        val image = bundle?.getString("image")
        imageUri = Uri.parse(image)
        Log.d("TAG", "onCreate: $imageUri")
        Glide.with(this)
            .load(imageUri)
            .into(binding.imageView)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return true
    }
}