package com.juanfran.electronic_emporium.domain.useCase.auth

import com.juanfran.electronic_emporium.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)

}