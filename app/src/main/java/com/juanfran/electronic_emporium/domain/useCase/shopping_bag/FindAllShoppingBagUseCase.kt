package com.juanfran.electronic_emporium.domain.useCase.shopping_bag

import com.juanfran.electronic_emporium.domain.repository.ShoppingBagRepository

class FindAllShoppingBagUseCase(private val repository: ShoppingBagRepository) {
    operator fun invoke() = repository.findAll()
}