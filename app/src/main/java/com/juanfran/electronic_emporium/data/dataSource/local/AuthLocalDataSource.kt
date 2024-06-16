package com.juanfran.electronic_emporium.data.dataSource.local

import com.juanfran.electronic_emporium.domain.model.AuthResponse
import com.juanfran.electronic_emporium.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}