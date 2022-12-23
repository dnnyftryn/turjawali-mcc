package com.aplikasi.mcc.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.mcc.App.Companion.context
import com.aplikasi.mcc.R
import com.aplikasi.mcc.activity.detail.GetDetailImageActivity
import com.aplikasi.mcc.data.AttendanceListItem
import com.aplikasi.mcc.databinding.ItemAbsensiBinding
import com.bumptech.glide.Glide
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class AbsensiAdapter(val data : List<AttendanceListItem?>) : RecyclerView.Adapter<AbsensiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAbsensiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size ?: 0

    inner class ViewHolder(private val binding: ItemAbsensiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(get: AttendanceListItem?) {
            val timenIn = get?.actualTimeIn
            val timenOut = get?.actualTimeOut
            val inputFormatter: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val date: Date = inputFormatter.parse(timenIn)
            val dateOut: Date = inputFormatter.parse(timenOut)

            val outputFormatter: DateFormat = SimpleDateFormat("HH:mm:ss")
            val output: String = outputFormatter.format(date) // Output : 01/20/2012
            val outputOut: String = outputFormatter.format(dateOut) // Output : 01/20/2012

            binding.textViewOfficerId.text = get?.officerName
            binding.textViewActualTimeIn.text = output
            binding.textViewActualTimeOut.text = outputOut
            binding.buttonLocIn.setOnClickListener {
                Log.d("TAG", "Latitude : ${get?.latIn} Longitude : ${get?.lngIn}")
            }
            binding.buttonLocOut.setOnClickListener {
                Log.d("TAG", "Latitude : ${get?.latOut} Longitude : ${get?.lngOut}")
            }

            val attdDate = get?.attdDate
            val inputFormatter1: DateFormat = SimpleDateFormat("yyyy-MM-dd")

            val outputFormatter1: DateFormat = SimpleDateFormat("dd-MM-yyyy")
            val output1: String = outputFormatter1.format(inputFormatter1.parse(attdDate)) // Output : 01/20/2012
            binding.textViewAttdDate.text = output1

            binding.ivAbsenMasuk.setOnClickListener {
                val intent = Intent(context, GetDetailImageActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("image", get?.picIn)
                startActivity(context, intent, null)
            }

            binding.ivAbsenPulang.setOnClickListener {
                val intent = Intent(context, GetDetailImageActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("image", get?.picOut)
                startActivity(context, intent, null)
            }

            binding.buttonLocIn.setOnClickListener {
                Log.d("TAG", "Latitude : ${get?.latIn} Longitude : ${get?.lngIn}")
            }

            binding.buttonLocOut.setOnClickListener {
                Log.d("TAG", "Latitude : ${get?.latOut} Longitude : ${get?.lngOut}")
            }

            val uriIn = get?.picIn
            val uriOut = get?.picOut

            if (uriIn != null) {
                Glide
                    .with(binding.root.context)
                    .load(uriIn)
                    .override(300, 300)
                    .into(binding.ivAbsenMasuk)
            } else {
                Glide.with(binding.root.context)
                    .load(R.drawable.notfound)
                    .override(300, 300)
                    .into(binding.ivAbsenMasuk)

            }

            if (uriOut != null) {
                Glide.with(binding.root.context)
                    .load(uriOut)
                    .override(300, 300)
                    .into(binding.ivAbsenPulang)
            } else {
                Glide.with(binding.root.context)
                    .load(R.drawable.notfound)
                    .override(300, 300)
                    .into(binding.ivAbsenPulang)

            }
        }
    }
}
