package com.juanfran.electronic_emporium.domain.useCase.orders

import com.juanfran.electronic_emporium.domain.repository.OrdersRepository

class FindAllOrdersUseCase(private val repository: OrdersRepository) {
    operator fun invoke() = repository.findAll()
}