package com.juanfran.electronic_emporium.domain.useCase.shopping_bag

data class ShoppingBagUseCase(
    val add: AddUseCase,
    val delete: DeleteUseCase,
    val findAll: FindAllShoppingBagUseCase,
    val findById: FindByIdShoppingBagUseCase,
    val getTotal: GetTotalUseCase
)
