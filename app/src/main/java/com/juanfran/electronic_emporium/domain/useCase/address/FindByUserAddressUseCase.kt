package com.juanfran.electronic_emporium.domain.useCase.address

import com.juanfran.electronic_emporium.domain.model.Address
import com.juanfran.electronic_emporium.domain.repository.AddressRepository

class FindByUserAddressUseCase(private val repository: AddressRepository) {
    suspend operator fun invoke(idUser: String) = repository.findByUser(idUser)
}