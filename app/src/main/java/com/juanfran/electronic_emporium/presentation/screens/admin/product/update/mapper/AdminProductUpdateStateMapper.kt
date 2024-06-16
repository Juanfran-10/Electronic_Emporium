package com.juanfran.electronic_emporium.presentation.screens.admin.product.update.mapper

import com.juanfran.electronic_emporium.domain.model.Product
import com.juanfran.electronic_emporium.presentation.screens.admin.product.create.AdminProductCreateState
import com.juanfran.electronic_emporium.presentation.screens.admin.product.update.AdminProductUpdateState

fun AdminProductUpdateState.toProduct(): Product {
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price,
        imagesToUpdate = imagesToUpdate.toList(),
        image1 = image1,
        image2 = image2
    )
}