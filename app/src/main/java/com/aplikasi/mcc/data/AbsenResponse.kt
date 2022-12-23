package com.aplikasi.mcc.data

import com.google.gson.annotations.SerializedName

data class AbsenResponse(

	@field:SerializedName("locationList")
	val locationList: List<LocationListItem>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Boolean,

	@field:SerializedName("dataCount")
	val dataCount: Int
)

data class LocationListItem(

	@field:SerializedName("Loc_ID")
	val locID: String,

	@field:SerializedName("Comp_ID")
	val compID: String,

	@field:SerializedName("Cust_ID")
	val custID: String,

	@field:SerializedName("Is_Active")
	val isActive: Int,

	@field:SerializedName("Is_Deleted")
	val isDeleted: Int,

	@field:SerializedName("Loc_Name")
	val locName: String,

	@field:SerializedName("Site_ID")
	val siteID: String,

	@field:SerializedName("Loc_QRCode")
	val locQRCode: String,

	@field:SerializedName("Loc_Desc")
	val locDesc: String,

	@field:SerializedName("Allow_Cam")
	val allowCam: Int,

	@field:SerializedName("Loc_NFC")
	val locNFC: String,

	@field:SerializedName("is_attendance")
	val isAttendance: Int
)
