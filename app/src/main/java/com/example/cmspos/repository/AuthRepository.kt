package com.example.cmspos.repository

import com.example.cmspos.model.Auth
import com.example.cmspos.model.AuthLogout
import com.example.cmspos.model.LoginOutput
import com.example.cmspos.service.AuthService

class AuthRepository(private val authService: AuthService) {
    fun login(user: Auth, onResult: (Boolean, String?, LoginOutput?) -> Unit) {
        authService.login(user, onResult)
    }
    fun logout(user: AuthLogout, onResult: (Boolean, String?, LoginOutput?) -> Unit) {
        authService.logout(user, onResult)
    }
}