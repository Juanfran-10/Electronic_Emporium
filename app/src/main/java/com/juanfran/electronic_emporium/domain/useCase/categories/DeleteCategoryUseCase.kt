package com.juanfran.electronic_emporium.domain.useCase.categories

import com.juanfran.electronic_emporium.domain.model.Category
import com.juanfran.electronic_emporium.domain.repository.CategoriesRepository
import java.io.File

class DeleteCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}