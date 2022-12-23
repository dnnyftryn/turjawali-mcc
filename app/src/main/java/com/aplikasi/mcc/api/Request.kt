package com.aplikasi.mcc.api

import com.aplikasi.mcc.data.*
import retrofit2.Call
import retrofit2.http.*
import javax.security.auth.callback.Callback

interface Request {

    @FormUrlEncoded
    @POST("mcc/login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET("ui/login/{comp}/{cust}")
    fun getBackground(
        @Header("Authorization") token: String,
        @Path("comp") compId: String,
        @Path("cust") custId: String
    ): Call<BackgroundResponse>

    @GET("mcc/client/list/{comp}/{cust}")
    fun getClient(
        @Header("Authorization") token: String,
        @Path("comp") compId: String,
        @Path("cust") custId: String
    ): Call<SiteListResponse>

    @GET("mcc/client/list/{comp}/{cust}/{site}")
    fun getSite(
        @Header("Authorization") token: String,
        @Path("comp") compId: String,
        @Path("cust") custId: String,
        @Path("site") siteId: String
    ): Call<AbsenResponse>

    @GET("mcc/absensi/laporan/{comp}/{cust}/{site}")
    fun getAbsensi(
        @Header("Authorization") token: String,
        @Path("comp") compId: String,
        @Path("cust") custId: String,
        @Path("site") siteId: String
    ): Call<AbsensiResponse>

}