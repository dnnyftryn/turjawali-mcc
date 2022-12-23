package com.aplikasi.mcc.pref

import android.content.Context

internal class LoginData (context: Context) {

    companion object {
        private const val PREFS_NAME = "mcc_pref"
        const val ID = "id"
        private const val IS_LOGIN = "is login"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val editor = preferences.edit()

    fun setLogin(value: Boolean) {
        editor.putBoolean(IS_LOGIN, value)
        editor.apply()
    }

    fun getLogin(): Boolean {
        return preferences.getBoolean(IS_LOGIN, false)
    }

    fun setUser(value: String) {
        editor.putString(ID, value)
        editor.apply()
    }

    fun setCompId(value: String) {
        editor.putString("Comp_ID", value)
        editor.apply()
    }

    fun setCustId(value: String) {
        editor.putString("Cust_ID", value)
        editor.apply()
    }

    fun setSiteId(value: String) {
        editor.putString("Site_ID", value)
        editor.apply()
    }

    fun setFullName(value: String) {
        editor.putString("Full_Name", value)
        editor.apply()
    }

    fun setEmail(value: String) {
        editor.putString("Email", value)
        editor.apply()
    }

    fun setIsActive(value: Int) {
        editor.putInt("Is_Active", value)
        editor.apply()
    }

    fun setIsPremium(value: Int) {
        editor.putInt("Is_Premium", value)
        editor.apply()
    }

    fun setLevelId(value: Int) {
        editor.putInt("Level_ID", value)
        editor.apply()
    }

    fun setOfficerLimit(value: Int) {
        editor.putInt("Officer_Limit", value)
        editor.apply()
    }

    fun setLocationLimit(value: Int) {
        editor.putInt("Location_Limit", value)
        editor.apply()
    }

    fun setIsCluster(value: Int) {
        editor.putInt("Is_Cluster", value)
        editor.apply()
    }

    fun setUserTitle(value: String) {
        editor.putString("User_Title", value)
        editor.apply()
    }

    fun setLastUpdate(value: String) {
        editor.putString("Last_Update", value)
        editor.apply()
    }

    fun setLastUpdateBy(value: String) {
        editor.putString("Last_Update_By", value)
        editor.apply()
    }

    fun setIntersite(value: String) {
        editor.putString("Is_Intersite", value)
    }

    fun setLastAttention(value: Int) {
        editor.putInt("Last_Attention", value)
        editor.apply()
    }

    fun setApiToken(value: String) {
        editor.putString("api_token", value)
        editor.apply()
    }

    fun setLogo(value: String) {
        editor.putString("Logo", value)
        editor.apply()
    }

    fun setBackground(value: String) {
        editor.putString("Background", value)
        editor.apply()
    }

    fun getLogo(): String {
        return preferences.getString("Logo", "").toString()
    }

    fun getBackground(): String {
        return preferences.getString("Background", "").toString()
    }

    fun getUser(): String {
        return preferences.getString(ID, null).toString()
    }

    fun getCompId(): String {
        return preferences.getString("Comp_ID", null).toString()
    }

    fun getCustId(): String {
        return preferences.getString("Cust_ID", null).toString()
    }

    fun getSiteId(): String {
        return preferences.getString("Site_ID", null).toString()
    }

    fun getFullName(): String {
        return preferences.getString("Full_Name", null).toString()
    }

    fun getEmail(): String {
        return preferences.getString("Email", null).toString()
    }

    fun getIsActive(): Int {
        return preferences.getInt("Is_Active", 0)
    }

    fun getIsPremium(): Int {
        return preferences.getInt("Is_Premium", 0)
    }

    fun getLevelId(): Int {
        return preferences.getInt("Level_ID", 0)
    }

    fun getOfficerLimit(): Int {
        return preferences.getInt("Officer_Limit", 0)
    }

    fun getLocationLimit(): Int {
        return preferences.getInt("Location_Limit", 0)
    }

    fun getIsCluster(): Int {
        return preferences.getInt("Is_Cluster", 0)
    }

    fun getUserTitle(): String {
        return preferences.getString("User_Title", null).toString()
    }

    fun getLastUpdate(): String {
        return preferences.getString("Last_Update", null).toString()
    }

    fun getLastUpdateBy(): String {
        return preferences.getString("Last_Update_By", null).toString()
    }

    fun getIntersite(): String {
        return preferences.getString("Is_Intersite", null).toString()
    }

    fun getLastAttention(): Int {
        return preferences.getInt("Last_Attention", 0)
    }

    fun getApiToken(): String {
        return "Bearer " + preferences.getString("api_token", null).toString()
    }

    fun removeData() {
        editor.clear()
        editor.commit()
    }
}