package com.juanfran.electronic_emporium.domain.useCase.shopping_bag

import com.juanfran.electronic_emporium.domain.repository.ShoppingBagRepository

class FindByIdShoppingBagUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) = repository.findById(id)
}