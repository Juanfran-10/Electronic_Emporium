package com.juanfran.electronic_emporium.domain.repository

import com.juanfran.electronic_emporium.domain.model.User
import com.juanfran.electronic_emporium.domain.util.Resource
import java.io.File

interface UsersRepository {
    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>
}