package com.aplikasi.mcc.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.aplikasi.mcc.MainActivity
import com.aplikasi.mcc.R
import com.aplikasi.mcc.data.DataMenu

internal class MenuAdapter(
    private val dataMenuList: ArrayList<DataMenu>,
    private val context: Context
    ): BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var menuTextView: TextView
    private lateinit var menuImageView: ImageView

    override fun getCount(): Int = dataMenuList.size

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (view == null) {
            view = layoutInflater!!.inflate(R.layout.item_grid, null)
        }

        menuTextView = view!!.findViewById(R.id.tvMenu)
        menuImageView = view.findViewById(R.id.ivMenu)

        menuTextView.text = dataMenuList[position].description
        menuImageView.setImageResource(dataMenuList[position].image!!)

        return view
    }

}