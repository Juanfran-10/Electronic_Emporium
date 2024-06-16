package com.juanfran.electronic_emporium.presentation.screens.auth.register.mapper

import com.juanfran.electronic_emporium.domain.model.User
import com.juanfran.electronic_emporium.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password
    )
}