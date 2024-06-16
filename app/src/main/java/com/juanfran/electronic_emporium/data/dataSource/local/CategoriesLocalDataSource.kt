package com.juanfran.electronic_emporium.data.dataSource.local

import com.juanfran.electronic_emporium.data.dataSource.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface CategoriesLocalDataSource {

    suspend fun create(category: CategoryEntity)
    suspend fun insertAll(categories: List<CategoryEntity>)
    fun getCategories(): Flow<List<CategoryEntity>>
    suspend fun update(id: String, name: String, description: String, image: String)
    suspend fun delete(id: String)

}