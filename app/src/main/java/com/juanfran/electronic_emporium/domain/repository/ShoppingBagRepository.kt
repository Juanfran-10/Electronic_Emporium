package com.juanfran.electronic_emporium.domain.repository

import com.juanfran.electronic_emporium.domain.model.Product
import com.juanfran.electronic_emporium.domain.model.ShoppingBagProduct
import kotlinx.coroutines.flow.Flow

interface ShoppingBagRepository {
    suspend fun add(product: ShoppingBagProduct)
    suspend fun delete(id: String)
    fun findAll(): Flow<List<ShoppingBagProduct>>
    suspend fun findById(id: String): ShoppingBagProduct?
    suspend fun getTotal(): Double
}