package com.example.cmspos.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.cmspos.model.AuthLogout
import com.example.cmspos.model.LoginOutput
import com.example.cmspos.repository.AuthRepository
import com.example.cmspos.service.AuthService

class LogoutViewModel : ViewModel() {
    private val authRepository = AuthRepository(AuthService())

    var isSuccessLogout by mutableStateOf(false)
    var errorMessage by mutableStateOf("")
    var userOutput by mutableStateOf<LoginOutput?>(null)

    fun onLogoutClick() {
        val user = AuthLogout(userOutput?.refresh_token)
        authRepository.logout(user) { success, message, output ->
            if (success) {
                isSuccessLogout = true
                errorMessage = ""
                userOutput = null
            } else {
                errorMessage = message ?: "Invalid credentials"
            }
        }
    }

}