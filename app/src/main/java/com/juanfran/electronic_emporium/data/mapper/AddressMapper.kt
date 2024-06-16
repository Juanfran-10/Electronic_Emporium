package com.juanfran.electronic_emporium.data.mapper

import com.juanfran.electronic_emporium.data.dataSource.local.entity.AddressEntity
import com.juanfran.electronic_emporium.domain.model.Address

fun AddressEntity.toAddress(): Address {
    return Address(
        id = id,
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}

fun Address.toEntity(): AddressEntity {
    return AddressEntity(
        id = id ?: "",
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}