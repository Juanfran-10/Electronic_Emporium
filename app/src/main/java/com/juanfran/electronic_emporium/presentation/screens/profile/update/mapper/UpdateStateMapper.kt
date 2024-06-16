package com.juanfran.electronic_emporium.presentation.screens.profile.update.mapper

import com.juanfran.electronic_emporium.domain.model.User
import com.juanfran.electronic_emporium.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}