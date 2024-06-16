package com.juanfran.electronic_emporium.data.repository

import com.juanfran.electronic_emporium.data.dataSource.local.AuthLocalDataSource
import com.juanfran.electronic_emporium.data.dataSource.remote.AuthRemoteDataSource
import com.juanfran.electronic_emporium.domain.model.AuthResponse
import com.juanfran.electronic_emporium.domain.model.User
import com.juanfran.electronic_emporium.domain.repository.AuthRepository
import com.juanfran.electronic_emporium.domain.util.Resource
import com.juanfran.electronic_emporium.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> =
        ResponseToRequest.send(
            authRemoteDataSource.login(email, password)
        )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) =
        authLocalDataSource.saveSession(authResponse)

    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)

    override suspend fun logout() = authLocalDataSource.logout()

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()
}