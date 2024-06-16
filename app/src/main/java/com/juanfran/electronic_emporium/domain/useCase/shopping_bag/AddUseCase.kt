package com.juanfran.electronic_emporium.domain.useCase.shopping_bag

import com.juanfran.electronic_emporium.domain.model.ShoppingBagProduct
import com.juanfran.electronic_emporium.domain.repository.ShoppingBagRepository

class AddUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(shoppingBagProduct: ShoppingBagProduct) {
        repository.add(shoppingBagProduct)
    }
}