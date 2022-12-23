package com.aplikasi.mcc.data

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("userData")
	val userData: UserData,

	@field:SerializedName("api_token")
	val apiToken: String,

	@field:SerializedName("last_attention")
	val lastAttention: Int,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Boolean
)

data class UserData(

	@field:SerializedName("is_cluster")
	val isCluster: Int,

	@field:SerializedName("Email")
	val email: String,

	@field:SerializedName("is_active")
	val isActive: Int,

	@field:SerializedName("Last_Update")
	val lastUpdate: String,

	@field:SerializedName("api_token")
	val apiToken: String,

	@field:SerializedName("expired_token")
	val expiredToken: String,

	@field:SerializedName("User_Password")
	val userPassword: String,

	@field:SerializedName("User_Title")
	val userTitle: String,

	@field:SerializedName("Customer_Image")
	val customerImage: String,

	@field:SerializedName("is_premium")
	val isPremium: Int,

	@field:SerializedName("Comp_ID")
	val compID: String,

	@field:SerializedName("Cust_ID")
	val custID: String,

	@field:SerializedName("Officer_Limit")
	val officerLimit: Int,

	@field:SerializedName("Last_Update_By")
	val lastUpdateBy: String,

	@field:SerializedName("enc_pass")
	val encPass: String,

	@field:SerializedName("Location_Limit")
	val locationLimit: Int,

	@field:SerializedName("Site_ID")
	val siteID: String,

	@field:SerializedName("FullName")
	val fullName: String,

	@field:SerializedName("Level_ID")
	val levelID: Int,

	@field:SerializedName("User_ID")
	val userID: String,

	@field:SerializedName("Is_Intersite")
	val isIntersite: String
)
