package com.aplikasi.mcc.activity.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aplikasi.mcc.R
import com.aplikasi.mcc.adapter.AbsensiAdapter
import com.aplikasi.mcc.api.RetrofitClient
import com.aplikasi.mcc.data.AbsensiResponse
import com.aplikasi.mcc.data.SiteListResponse
import com.aplikasi.mcc.databinding.ActivityAbsensiBinding
import com.aplikasi.mcc.databinding.SearchDialogBinding
import com.aplikasi.mcc.pref.LoginData
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Response

class AbsensiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAbsensiBinding
    private lateinit var pref: LoginData

    private var siteList: MutableList<String> = mutableListOf()

    private val _resultSite: MutableLiveData<String> = MutableLiveData()
    private val resultSite: LiveData<String> = _resultSite

    private var siteId = ""
    private lateinit var adapter: AbsensiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbsensiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = LoginData(this)
        adapter = AbsensiAdapter(arrayListOf())

        supportActionBar!!.title = "Absensi"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        site()

        resultSite.observe(this) { site ->
            if (site == "SEMUA") {
                siteId = pref.getSiteId()
            } else {
                siteId = site
            }
        }
        Log.d("siteIdNYA HARUS JADI", siteId)
        Log.d("siteIdNYA HARUS JADI", resultSite.toString())



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
                        }
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.appSearchBar -> {
            val dialog = BottomSheetDialog(this)
            val dialogBinding = SearchDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            val arrayAdapter = ArrayAdapter(this, R.layout.custom_dropdown, siteList)
            dialogBinding.tvState.setAdapter(arrayAdapter)

            dialogBinding.tvState.setOnItemClickListener { _, _, position, _ ->
                _resultSite.value = siteList[position]
                dialogBinding.tvState.setText(siteList[position])
                // POSISI
                if (position == 0) {
                    dialogBinding.tvState.setText("SEMUA")
                    pref.getSiteId()
                }
                else {
                    dialogBinding.tvState.setText(siteList[position])
                }

                val siteId = siteList[position]
                _resultSite.postValue(siteId)
            }
            dialogBinding.show.setOnClickListener {
                val token = pref.getApiToken()
                val compId = pref.getCompId()
                val custId = pref.getCustId()
                getAbsenSite(token, compId, custId, siteId)
                dialog.dismiss()
            }
            dialog.show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    fun getAbsenSite(token: String, compId: String, custId: String, siteId: String) {
        RetrofitClient.instance
            .getAbsensi(token, compId, custId, siteId)
            .enqueue(object : retrofit2.Callback<AbsensiResponse>{
                override fun onResponse(
                    call: Call<AbsensiResponse>,
                    response: Response<AbsensiResponse>
                ) {

                    if (response.code() == 200) {
                        if (response.body()?.dataCount == 0) {
                            Snackbar.make(binding.root, "Data tidak ditemukan", Snackbar.LENGTH_SHORT).show()
                            binding.recyclerViewAttendance.visibility = View.GONE
                        } else {
                            binding.search.bar.visibility = View.VISIBLE
                            binding.recyclerViewAttendance.adapter = response.body()?.attendanceList?.let {
                                AbsensiAdapter(it)
                            }
                        }
                    }
                    Log.d("TAG", "onResponse: ${response.body()}")
                }

                override fun onFailure(call: Call<AbsensiResponse>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message}")
                }

            })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}