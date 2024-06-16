package com.juanfran.electronic_emporium.domain.repository

import com.juanfran.electronic_emporium.domain.model.Address
import com.juanfran.electronic_emporium.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AddressRepository {

    suspend fun create(address: Address): Resource<Address>
    fun findByUser(idUser: String): Flow<Resource<List<Address>>>

}