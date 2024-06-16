package com.juanfran.electronic_emporium.domain.repository

import com.juanfran.electronic_emporium.domain.model.Order
import com.juanfran.electronic_emporium.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {
    fun findAll(): Flow<Resource<List<Order>>>
    fun findByClient(idClient: String): Flow<Resource<List<Order>>>
    suspend fun updateStatus(id: String): Resource<Order>
}