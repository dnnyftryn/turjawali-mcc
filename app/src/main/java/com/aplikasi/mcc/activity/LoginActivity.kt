package com.aplikasi.mcc.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.aplikasi.mcc.MainActivity
import com.aplikasi.mcc.api.RetrofitClient
import com.aplikasi.mcc.data.BackgroundResponse
import com.aplikasi.mcc.data.LoginResponse
import com.aplikasi.mcc.databinding.ActivityLoginBinding
import com.aplikasi.mcc.helper.Base64Helper
import com.aplikasi.mcc.pref.LoginData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var pref: LoginData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = LoginData(this)
        supportActionBar?.hide()

        binding.btnLogin.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.etPassword.text.toString()

            when {
                username.isEmpty() -> {
                    binding.username.error = "Username tidak boleh kosong"
                    binding.username.requestFocus()
                }
                password.isEmpty() -> {
                    binding.etPassword.error = "Password tidak boleh kosong"
                    binding.etPassword.requestFocus()
                }
                else -> {
                    lifecycleScope.launch {
                        login(username, password)
                    }
                }
            }
        }
    }



    private fun login(username: String, password: String) {
        RetrofitClient.instance
            .login(username, password)
            .enqueue(object  : retrofit2.Callback<LoginResponse>{
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.code() == 200) {
                        val result = response.body()
                        if (result?.status == true ) {
                            pref.setApiToken(result.apiToken)
                            pref.setUser(result.userData.userID)
                            pref.setCompId(result.userData.compID)
                            pref.setCustId(result.userData.custID)
                            pref.setSiteId(result.userData.siteID)
                            pref.setFullName(result.userData.fullName)
                            pref.setEmail(result.userData.email)
                            pref.setIsActive(result.userData.isActive)
                            pref.setIsPremium(result.userData.isPremium)
                            pref.setLevelId(result.userData.levelID)
                            pref.setOfficerLimit(result.userData.officerLimit)
                            pref.setLocationLimit(result.userData.locationLimit)
                            pref.setIsCluster(result.userData.isCluster)
                            pref.setUserTitle(result.userData.userTitle)
                            pref.setLastUpdate(result.userData.lastUpdate)
                            pref.setLastUpdateBy(result.userData.lastUpdateBy)
                            pref.setIntersite(result.userData.isIntersite)
                            pref.setLastAttention(result.lastAttention)
                            pref.setLogin(true)

                            getBackground()

                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))

                        }
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message}")
                }

            })
    }

    private fun getBackground() {
        val token = pref.getApiToken()
        val compId = pref.getCompId()
        val custId = pref.getCustId()

        RetrofitClient.instance
            .getBackground(token, compId, custId)
            .enqueue(object : retrofit2.Callback<BackgroundResponse>{
                override fun onResponse(
                    call: Call<BackgroundResponse>,
                    response: Response<BackgroundResponse>
                ) {
                    val result = response.body()
                    val image = result?.background?.logo
                    if (response.code() == 200) {
                        if (result?.status == true) {
                            pref.setBackground(image!!)
                            Log.d("TAG", "onResponse: ${pref.getBackground()}")
                        }
                    }
                }


                override fun onFailure(call: Call<BackgroundResponse>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message}")
                }

            })
    }


}