package com.juanfran.electronic_emporium.domain.useCase.products

import com.juanfran.electronic_emporium.domain.repository.ProductsRepository

class FindByCategoryUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(idCategory: String) = repository.findByCategory(idCategory)
}