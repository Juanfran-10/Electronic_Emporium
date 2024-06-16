package com.juanfran.electronic_emporium.data.mapper

import com.juanfran.electronic_emporium.data.dataSource.local.entity.ShoppingBagProductEntity
import com.juanfran.electronic_emporium.domain.model.ShoppingBagProduct

fun ShoppingBagProduct.toEntity(): ShoppingBagProductEntity {
    return ShoppingBagProductEntity(
        id = id,
        name = name,
        idCategory = idCategory,
        image1 = image1,
        price = price,
        quantity = quantity
    )
}

fun ShoppingBagProductEntity.toShoppingBagProduct(): ShoppingBagProduct {
    return ShoppingBagProduct(
        id = id,
        name = name,
        idCategory = idCategory,
        image1 = image1,
        price = price,
        quantity = quantity
    )
}