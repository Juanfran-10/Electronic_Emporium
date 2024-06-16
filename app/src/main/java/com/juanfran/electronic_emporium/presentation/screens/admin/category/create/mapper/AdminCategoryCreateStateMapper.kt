package com.juanfran.electronic_emporium.presentation.screens.admin.category.create.mapper

import com.juanfran.electronic_emporium.domain.model.Category
import com.juanfran.electronic_emporium.presentation.screens.admin.category.create.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}