package com.juanfran.electronic_emporium.domain.useCase.orders

data class OrdersUseCase(
    val findAllOrders: FindAllOrdersUseCase,
    val findByClientOrders: FindByClientOrdersUseCase,
    val updateStatusOrders: UpdateStatusOrdersUseCase
)
