package com.juanfran.electronic_emporium.domain.useCase.users

import com.juanfran.electronic_emporium.domain.model.User
import com.juanfran.electronic_emporium.domain.repository.UsersRepository
import java.io.File

class UpdateUserWithImageUseCase(private val repository: UsersRepository) {
    suspend operator fun invoke(id: String, user: User, file: File) =
        repository.updateWithImage(id, user, file)
}