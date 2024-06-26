package com.juanfran.electronic_emporium.domain.repository

import com.juanfran.electronic_emporium.domain.model.Product
import com.juanfran.electronic_emporium.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface ProductsRepository {
    fun findAll(): Flow<Resource<List<Product>>>
    fun findByCategory(idCategory: String): Flow<Resource<List<Product>>>
    fun findByName(name: String): Flow<Resource<List<Product>>>
    suspend fun create(product: Product, files: List<File>): Resource<Product>
    suspend fun updateWithImage(id: String, product: Product, files: List<File>?): Resource<Product>
    suspend fun update(id: String, product: Product): Resource<Product>
    suspend fun delete(id: String): Resource<Unit>
}