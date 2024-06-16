package com.juanfran.electronic_emporium.presentation.screens.client.address.create.mapper

import com.juanfran.electronic_emporium.domain.model.Address
import com.juanfran.electronic_emporium.presentation.screens.client.address.create.ClientAddressCreateState

fun ClientAddressCreateState.toAddress(): Address {
    return Address(
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}