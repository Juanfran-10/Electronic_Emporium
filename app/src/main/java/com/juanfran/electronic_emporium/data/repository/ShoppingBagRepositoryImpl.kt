package com.juanfran.electronic_emporium.data.repository

import android.util.Log
import com.juanfran.electronic_emporium.data.dataSource.local.ShoppingBagLocalDataSource
import com.juanfran.electronic_emporium.data.mapper.toEntity
import com.juanfran.electronic_emporium.data.mapper.toShoppingBagProduct
import com.juanfran.electronic_emporium.domain.model.ShoppingBagProduct
import com.juanfran.electronic_emporium.domain.repository.ShoppingBagRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ShoppingBagRepositoryImpl(private val localDataSource: ShoppingBagLocalDataSource) :
    ShoppingBagRepository {
    override suspend fun add(product: ShoppingBagProduct) {
        CoroutineScope(Dispatchers.IO).launch {
            val shoppingBag = localDataSource.findById(product.id)
            if (shoppingBag == null) {
                Log.d("ShoppingBagRepositoryImpl", "Creando datos")

                localDataSource.insert(product.toEntity())
            } else {
                Log.d("ShoppingBagRepositoryImpl", "Actualizando datos")
                localDataSource.update(product.id, product.quantity)
            }
        }
    }

    override suspend fun delete(id: String) {
        localDataSource.delete(id)
    }

    override fun findAll(): Flow<List<ShoppingBagProduct>> = flow {
        localDataSource.findAll().collect() {
            emit(it.map { entity -> entity.toShoppingBagProduct() })
        }
    }

    override suspend fun findById(id: String): ShoppingBagProduct? {
        val data = runBlocking(context = Dispatchers.IO) {
            localDataSource.findById(id)
        }
        if (data != null) {
            return data.toShoppingBagProduct()
        }
        return null
    }

    override suspend fun getTotal(): Double = localDataSource.getTotal()
}