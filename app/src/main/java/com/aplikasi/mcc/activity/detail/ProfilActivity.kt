package com.aplikasi.mcc.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aplikasi.mcc.databinding.ActivityProfilBinding
import com.aplikasi.mcc.pref.LoginData

class ProfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfilBinding
    private lateinit var pref: LoginData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = LoginData(this)
        supportActionBar?.hide()

        binding.textViewFullname.text = pref.getFullName()
        binding.textViewUserId.text = pref.getUser()
        binding.textViewEmail.text = pref.getEmail()
        binding.textViewCustID.text = pref.getCustId()
        binding.textViewSiteID.text = pref.getSiteId()
        binding.textViewUserIntersite.text = pref.getIntersite()


        binding.editPw.setOnClickListener {
            Log.d("PREF", "onCreate: ${pref.getFullName()}, ${pref.getEmail()}, ${pref.getCustId()}, ${pref.getSiteId()}, ${pref.getIntersite()}")
        }
    }
}