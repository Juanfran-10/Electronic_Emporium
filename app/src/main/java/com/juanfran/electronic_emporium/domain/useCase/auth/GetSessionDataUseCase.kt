package com.juanfran.electronic_emporium.domain.useCase.auth

import com.juanfran.electronic_emporium.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}