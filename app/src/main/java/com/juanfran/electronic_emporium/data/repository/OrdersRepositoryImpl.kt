package com.juanfran.electronic_emporium.data.repository

import com.juanfran.electronic_emporium.data.dataSource.remote.OrdersRemoteDataSource
import com.juanfran.electronic_emporium.domain.model.Order
import com.juanfran.electronic_emporium.domain.repository.OrdersRepository
import com.juanfran.electronic_emporium.domain.util.Resource
import com.juanfran.electronic_emporium.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OrdersRepositoryImpl(private val remoteDataSource: OrdersRemoteDataSource) :
    OrdersRepository {
    override fun findAll(): Flow<Resource<List<Order>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findAll()))
    }

    override fun findByClient(idClient: String): Flow<Resource<List<Order>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByClient(idClient)))
    }

    override suspend fun updateStatus(id: String): Resource<Order> = ResponseToRequest.send(
        remoteDataSource.updateStatus(id)
    )
}