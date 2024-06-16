package com.juanfran.electronic_emporium.data.repository

import com.juanfran.electronic_emporium.data.dataSource.remote.UsersRemoteDataSource
import com.juanfran.electronic_emporium.domain.model.User
import com.juanfran.electronic_emporium.domain.repository.UsersRepository
import com.juanfran.electronic_emporium.domain.util.Resource
import com.juanfran.electronic_emporium.domain.util.ResponseToRequest
import java.io.File

class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,
) : UsersRepository {
    override suspend fun update(id: String, user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )

    override suspend fun updateWithImage(id: String, user: User, file: File) =
        ResponseToRequest.send(
            usersRemoteDataSource.updateWithImage(id, user, file)
        )
}