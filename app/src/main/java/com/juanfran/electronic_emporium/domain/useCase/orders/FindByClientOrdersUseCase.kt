package com.juanfran.electronic_emporium.domain.useCase.orders

import com.juanfran.electronic_emporium.domain.repository.OrdersRepository

class FindByClientOrdersUseCase(private val repository: OrdersRepository) {
    operator fun invoke(idClient: String) = repository.findByClient(idClient)
}