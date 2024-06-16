package com.juanfran.electronic_emporium.domain.useCase.users

import com.juanfran.electronic_emporium.domain.model.User
import com.juanfran.electronic_emporium.domain.repository.UsersRepository

class UpdateUserUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)

}