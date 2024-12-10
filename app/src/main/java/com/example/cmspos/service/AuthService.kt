package com.example.cmspos.service

import android.util.Log
import com.example.cmspos.model.Auth
import com.example.cmspos.model.LoginResponse
import com.example.cmspos.model.LoginOutput
import com.example.cmspos.retrofit.AuthApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request

class AuthService {
    private val headerInterceptor = Interceptor { chain ->
        val originalRequest: Request = chain.request()
        val newRequest: Request = originalRequest.newBuilder()
            .addHeader("x-project", "dashboard")
            .build()
        chain.proceed(newRequest)
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://kong.eratech.id")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val authApi: AuthApi = retrofit.create(AuthApi::class.java)

    fun login(user: Auth, onResult: (Boolean, String?, LoginOutput?) -> Unit) {
        authApi.login(user).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful && response.body()?.data != null) {
                    val userOutput = response.body()?.data
                    Log.d("LoginResponse", "UserOutput: $userOutput")
                    onResult(true, null, userOutput)
                } else {
                    onResult(false, response.body()?.error_message ?: "Login failed.", null)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onResult(false, t.message, null)
            }
        })
    }
}
