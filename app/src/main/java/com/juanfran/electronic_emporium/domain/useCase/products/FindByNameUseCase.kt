package com.juanfran.electronic_emporium.domain.useCase.products

import com.juanfran.electronic_emporium.domain.repository.ProductsRepository

class FindByNameUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(name: String) = repository.findByName(name)
}