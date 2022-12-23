package com.aplikasi.mcc.data

import com.google.gson.annotations.SerializedName

data class SiteListResponse(

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("siteList")
	val siteList: List<SiteListItem>,

	@field:SerializedName("status")
	val status: Boolean,

	@field:SerializedName("dataCount")
	val dataCount: Int
)

data class SiteListItem(

	@field:SerializedName("Comp_ID")
	val compID: String,

	@field:SerializedName("Cust_ID")
	val custID: String,

	@field:SerializedName("Site_Name")
	val siteName: String,

	@field:SerializedName("Site_ID")
	val siteID: String
)
