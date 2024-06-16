package com.juanfran.electronic_emporium.presentation.screens.admin.product.create.mapper

import com.juanfran.electronic_emporium.domain.model.Product
import com.juanfran.electronic_emporium.presentation.screens.admin.product.create.AdminProductCreateState

fun AdminProductCreateState.toProduct(): Product {
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price
    )
}