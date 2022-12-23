package com.aplikasi.mcc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.GridView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aplikasi.mcc.activity.*
import com.aplikasi.mcc.activity.detail.ProfilActivity
import com.aplikasi.mcc.activity.list.*
import com.aplikasi.mcc.adapter.MenuAdapter
import com.aplikasi.mcc.api.RetrofitClient
import com.aplikasi.mcc.data.DataMenu
import com.aplikasi.mcc.data.SiteListResponse
import com.aplikasi.mcc.databinding.ActivityMainBinding
import com.aplikasi.mcc.pref.LoginData
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var menuGridView: GridView
    private lateinit var menuList: ArrayList<DataMenu>

    private lateinit var pref: LoginData

    private var siteList: MutableList<String> = mutableListOf()

    private val _resultSite: MutableLiveData<String> = MutableLiveData()
    private val resultSite: LiveData<String> = _resultSite

    private var siteId = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        pref = LoginData(this)

        menuGridView = binding.gridViewMenu
        menuList = ArrayList()

        menuList.add(DataMenu("PROFIL", R.drawable.ic_user))
        menuList.add(DataMenu("ABSENSI", R.drawable.ic_fingerprint_scanner))
        menuList.add(DataMenu("PATROLI", R.drawable.ic_scheduled_patrols))
        menuList.add(DataMenu("AKTIVITAS", R.drawable.ic_security_monitoring))
        menuList.add(DataMenu("ATENSI", R.drawable.ic_notification))
        menuList.add(DataMenu("TEMPAT", R.drawable.ic_mall_security))
        menuList.add(DataMenu("POS PATROLI", R.drawable.ic_gps_tracker))
        menuList.add(DataMenu("PETUGAS", R.drawable.ic_guard_services))
        menuList.add(DataMenu("KOREKSI", R.drawable.ic_fingerprint_scanner))
        menuList.add(DataMenu("KOREKSI", R.drawable.ic_fingerprint_scanner))

        val menuAdapter = MenuAdapter(menuList, this)
        menuGridView.adapter = menuAdapter

        menuGridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    startActivity(Intent(this, ProfilActivity::class.java))
                }
                1 -> {
                    startActivity(Intent(this, AbsensiActivity::class.java))
                }
                2 -> {
                    startActivity(Intent(this, PatroliActivity::class.java))
                }
                3 -> {
                    startActivity(Intent(this, AktivitasActivity::class.java))
                }
                4 -> {
                    startActivity(Intent(this, AtensiActivity::class.java))
                }
                5 -> {
                    startActivity(Intent(this, SiteActivity::class.java))
                }
                6 -> {
                    startActivity(Intent(this, PosPatroliActivity::class.java))
                }
                7 -> {
                    startActivity(Intent(this, PetugasActivity::class.java))
                }
                8 -> {
                    startActivity(Intent(this, KoreksiActivity::class.java))
                }
                9 -> {
                    pref.removeData()
                    pref.editor.clear().commit()
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
        }

        site()

        resultSite.observe(this) {
            Log.d("TAG", "onCreate: $it")
        }

    }

    private fun site() {
        val token = pref.getApiToken()
        val compId = pref.getCompId()
        val custId = pref.getCustId()

        RetrofitClient.instance
            .getClient(token, compId, custId)
            .enqueue(object : retrofit2.Callback<SiteListResponse>{
                override fun onResponse(
                    call: Call<SiteListResponse>,
                    response: Response<SiteListResponse>
                ) {
                    val result = response.body()
                    val status = result?.status
                    if (response.code() == 200) {
                        if (status == true) {
                            siteList.add("SEMUA")
                            result.siteList.forEach {
                                siteList.add(it.siteName)
                            }
                            Log.d("TAG", "onResponse: $siteList")
                        }gi
                        else {
                            Log.d("TAG", "onResponse: ${result?.message}")
                        }
                    }
                    else {
                        Log.d("TAG", "onResponse: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<SiteListResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}