package com.juanfran.electronic_emporium.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanfran.electronic_emporium.domain.model.AuthResponse
import com.juanfran.electronic_emporium.domain.model.User
import com.juanfran.electronic_emporium.domain.useCase.auth.AuthUseCase
import com.juanfran.electronic_emporium.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            Log.d("LoginViewModel", "Data: ${data.toJson()}")
            if (!data.token.isNullOrBlank()) {
                loginResponse = Resource.Success(data)
            }
        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun login() = viewModelScope.launch {

        if (isValidForm()) {
            loginResponse = Resource.Loading //ESPERANDO
            val result = authUseCase.login(state.email, state.password) //RETORNA UNA RESPUESTA
            loginResponse = result //EXITOSA / ERROR
        }
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }


    fun isValidForm(): Boolean {

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es válido"
            return false
        } else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        return true
    }
}