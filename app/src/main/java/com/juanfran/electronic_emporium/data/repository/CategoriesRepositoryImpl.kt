package com.juanfran.electronic_emporium.data.repository

import android.util.Log
import com.juanfran.electronic_emporium.data.dataSource.local.CategoriesLocalDataSource
import com.juanfran.electronic_emporium.data.dataSource.remote.CategoriesRemoteDataSource
import com.juanfran.electronic_emporium.data.mapper.toCategory
import com.juanfran.electronic_emporium.data.mapper.toCategoryEntity
import com.juanfran.electronic_emporium.domain.model.Category
import com.juanfran.electronic_emporium.domain.repository.CategoriesRepository
import com.juanfran.electronic_emporium.domain.util.Resource
import com.juanfran.electronic_emporium.domain.util.ResponseToRequest
import com.juanfran.electronic_emporium.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.io.File
class CategoriesRepositoryImpl(
    private val remoteDataSource: CategoriesRemoteDataSource,
    private val localDataSource: CategoriesLocalDataSource
): CategoriesRepository {

    override suspend fun create(category: Category, file: File): Resource<Category> {
        ResponseToRequest.send(remoteDataSource.create(category, file)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.create(this.data.toCategoryEntity())
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override fun getCategories(): Flow<Resource<List<Category>>> = flow {

        localDataSource.getCategories().collect() {
            it.run {
                val categoriesLocalMap = this.map { categoryEntity -> categoryEntity.toCategory()  }

                try {
                    ResponseToRequest.send(remoteDataSource.getCategories()).run {
                        when(this) {
                            is Resource.Success -> {
                                val categoriesRemote = this.data

                                if (!isListEqual(categoriesRemote, categoriesLocalMap)) {
                                    localDataSource.insertAll(categoriesRemote.map { category -> category.toCategoryEntity() })
                                }

                                emit(Resource.Success(categoriesRemote))
                            }
                            is Resource.Failure -> {
                                emit(Resource.Success(categoriesLocalMap))
                            }
                            else -> {
                                emit(Resource.Success(categoriesLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(categoriesLocalMap))
                }

            }
        }

    }.flowOn(Dispatchers.IO)


    override suspend fun update(id: String, category: Category): Resource<Category> {

        ResponseToRequest.send(remoteDataSource.update(id, category)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }

    }

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, category, file)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override suspend fun delete(id: String): Resource<Unit> {
        ResponseToRequest.send(remoteDataSource.delete(id)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.delete(id)
                    Resource.Success(Unit)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }
}

