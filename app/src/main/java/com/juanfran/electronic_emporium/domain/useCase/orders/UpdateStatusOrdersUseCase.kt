package com.juanfran.electronic_emporium.domain.useCase.orders

import com.juanfran.electronic_emporium.domain.repository.OrdersRepository

class UpdateStatusOrdersUseCase(private val repository: OrdersRepository) {
    suspend operator fun invoke(id: String) = repository.updateStatus(id)
}