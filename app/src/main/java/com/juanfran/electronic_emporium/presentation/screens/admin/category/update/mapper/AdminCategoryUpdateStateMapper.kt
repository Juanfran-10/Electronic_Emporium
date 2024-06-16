package com.juanfran.electronic_emporium.presentation.screens.admin.category.update.mapper

import com.juanfran.electronic_emporium.domain.model.Category
import com.juanfran.electronic_emporium.presentation.screens.admin.category.create.AdminCategoryCreateState
import com.juanfran.electronic_emporium.presentation.screens.admin.category.update.AdminCategoryUpdateState

fun AdminCategoryUpdateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}