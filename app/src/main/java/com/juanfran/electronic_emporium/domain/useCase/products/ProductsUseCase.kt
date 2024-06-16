package com.juanfran.electronic_emporium.domain.useCase.products

data class ProductsUseCase(
    val createProduct: CreateProductUseCase,
    val findByCategory: FindByCategoryUseCase,
    val findAll: FindAllUseCase,
    val updateProduct: UpdateProductUseCase,
    val updateProductWithImage: UpdateProductWithImageUseCase,
    val deleteProduct: DeleteProductUseCase,
    val findByName: FindByNameUseCase
)
