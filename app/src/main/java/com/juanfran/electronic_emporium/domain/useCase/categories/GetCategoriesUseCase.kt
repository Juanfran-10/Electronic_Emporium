package com.juanfran.electronic_emporium.domain.useCase.categories

import com.juanfran.electronic_emporium.domain.model.Category
import com.juanfran.electronic_emporium.domain.repository.CategoriesRepository
import java.io.File

class GetCategoriesUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke() = repository.getCategories()
}