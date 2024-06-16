package com.juanfran.electronic_emporium.domain.useCase.products

import com.juanfran.electronic_emporium.domain.model.Product
import com.juanfran.electronic_emporium.domain.repository.ProductsRepository

class UpdateProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String, product: Product) = repository.update(id, product)
}