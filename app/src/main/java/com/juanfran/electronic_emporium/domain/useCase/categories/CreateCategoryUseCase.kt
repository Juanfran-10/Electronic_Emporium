package com.juanfran.electronic_emporium.domain.useCase.categories

import com.juanfran.electronic_emporium.domain.model.Category
import com.juanfran.electronic_emporium.domain.repository.CategoriesRepository
import java.io.File

class CreateCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(category: Category, file: File) = repository.create(category, file)
}