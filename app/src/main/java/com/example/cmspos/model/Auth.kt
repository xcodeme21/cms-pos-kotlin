package com.example.cmspos.model

data class Auth(
    val username: String,
    val password: String
)

data class LoginResponse(
    val data: LoginOutput?,
    val error_message: String?,
    val status: Number
)

data class LoginOutput(
    val message: String,
    val access_token: String,
    val expired_in: Number,
    val refresh_token: String,
    val refresh_expired_in: Number
)