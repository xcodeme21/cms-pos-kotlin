package com.example.cmspos.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.cmspos.model.Auth
import com.example.cmspos.model.LoginOutput
import com.example.cmspos.repository.AuthRepository
import com.example.cmspos.service.AuthService

class LoginViewModel : ViewModel() {
    private val authRepository = AuthRepository(AuthService())

    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var isLoggedIn by mutableStateOf(false)
    var errorMessage by mutableStateOf("")
    var userOutput by mutableStateOf<LoginOutput?>(null)

    fun onLoginClick() {
        val user = Auth(username, password)
        authRepository.login(user) { success, message, output ->
            if (success) {
                isLoggedIn = true
                errorMessage = ""
                userOutput = output
            } else {
                errorMessage = message ?: "Invalid credentials"
            }
        }
    }

    fun isFormValid() = username.isNotEmpty() && password.isNotEmpty()
}