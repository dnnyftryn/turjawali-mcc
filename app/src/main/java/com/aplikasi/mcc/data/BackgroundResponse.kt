package com.aplikasi.mcc.data

import com.google.gson.annotations.SerializedName

data class BackgroundResponse(

	@field:SerializedName("background")
	val background: Background,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Boolean
)

data class Background(

	@field:SerializedName("Logo_Icon")
	val logoIcon: Any,

	@field:SerializedName("Background_Img")
	val backgroundImg: Any,

	@field:SerializedName("App_Name3")
	val appName3: Any,

	@field:SerializedName("App_Name2")
	val appName2: String,

	@field:SerializedName("App_Name1")
	val appName1: String,

	@field:SerializedName("MCC_Name1")
	val mCCName1: String,

	@field:SerializedName("Logo")
	val logo: String,

	@field:SerializedName("MCC_Name2")
	val mCCName2: Any
)
