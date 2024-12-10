package com.example.cmspos.retrofit

import com.example.cmspos.model.Auth
import com.example.cmspos.model.AuthLogout
import com.example.cmspos.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {
    @Headers("Content-Type: application/json")
    @POST("/auth/v1/cms/auth/login")
    fun login(@Body user: Auth): Call<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("/auth/v1/cms/auth/logout")
    fun logout(@Body user: AuthLogout): Call<LoginResponse>
}