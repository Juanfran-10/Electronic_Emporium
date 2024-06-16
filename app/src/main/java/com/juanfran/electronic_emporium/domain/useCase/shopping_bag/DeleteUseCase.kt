package com.juanfran.electronic_emporium.domain.useCase.shopping_bag

import com.juanfran.electronic_emporium.domain.model.ShoppingBagProduct
import com.juanfran.electronic_emporium.domain.repository.ShoppingBagRepository

class DeleteUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) {
        repository.delete(id)
    }
}