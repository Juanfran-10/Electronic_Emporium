package com.juanfran.electronic_emporium.data.dataSource.local

import com.juanfran.electronic_emporium.data.dataSource.local.datastore.AuthDatastore
import com.juanfran.electronic_emporium.domain.model.AuthResponse
import com.juanfran.electronic_emporium.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore) :
    AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)
    override suspend fun updateSession(user: User) = authDatastore.update(user)
    override suspend fun logout() = authDatastore.delete()
    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()
}