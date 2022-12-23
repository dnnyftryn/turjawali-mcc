package com.aplikasi.mcc.data

import com.google.gson.annotations.SerializedName

data class AbsensiResponse(

	@field:SerializedName("attendanceList")
	val attendanceList: List<AttendanceListItem?>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Boolean,

	@field:SerializedName("dataCount")
	val dataCount: Int
)

data class AttendanceListItem(

	@field:SerializedName("Report_Selected")
	val reportSelected: Int,

	@field:SerializedName("Pic_In")
	val picIn: String,

	@field:SerializedName("LngOut")
	val lngOut: String,

	@field:SerializedName("Pic_Out")
	val picOut: String,

	@field:SerializedName("LngIn")
	val lngIn: String,

	@field:SerializedName("officer_name")
	val officerName: String,

	@field:SerializedName("Pic_In_Sub")
	val picInSub: String,

	@field:SerializedName("Attd_Date")
	val attdDate: String,

	@field:SerializedName("Pic_In_Alt")
	val picInAlt: String,

	@field:SerializedName("LatOut")
	val latOut: String,

	@field:SerializedName("Comp_ID")
	val compID: String,

	@field:SerializedName("Cust_ID")
	val custID: String,

	@field:SerializedName("Site_ID")
	val siteID: String,

	@field:SerializedName("LatIn")
	val latIn: String,

	@field:SerializedName("Actual_TimeOut")
	val actualTimeOut: String,

	@field:SerializedName("Pic_Out_Sub")
	val picOutSub: String,

	@field:SerializedName("ID")
	val iD: Int,

	@field:SerializedName("Actual_TimeIn")
	val actualTimeIn: String,

	@field:SerializedName("Pic_Out_Alt")
	val picOutAlt: String
)
