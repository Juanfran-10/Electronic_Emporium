package com.juanfran.electronic_emporium.domain.useCase.address

data class AddressUseCase(
    val createAddress: CreateAddressUseCase,
    val findByUserAddress: FindByUserAddressUseCase,
)
