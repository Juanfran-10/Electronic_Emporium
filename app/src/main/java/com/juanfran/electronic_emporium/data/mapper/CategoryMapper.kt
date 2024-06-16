package com.juanfran.electronic_emporium.data.mapper

import com.juanfran.electronic_emporium.data.dataSource.local.entity.CategoryEntity
import com.juanfran.electronic_emporium.domain.model.Category

fun CategoryEntity.toCategory(): Category {
    return Category(
        id = id,
        name = name,
        description = description,
        image = image
    )
}

fun Category.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        id = id ?: "",
        name = name,
        description = description,
        image = image ?: ""
    )
}