package com.juanfran.electronic_emporium.domain.useCase.products

import com.juanfran.electronic_emporium.domain.model.Product
import com.juanfran.electronic_emporium.domain.repository.ProductsRepository
import java.io.File

class CreateProductUseCase(private val repository: ProductsRepository) {

    suspend operator fun invoke(product: Product, files: List<File>) = repository.create(product, files)

}