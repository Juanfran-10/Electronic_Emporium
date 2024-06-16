package com.juanfran.electronic_emporium.data.dataSource.remote

import com.juanfran.electronic_emporium.domain.model.Address
import retrofit2.Response

interface AddressRemoteDataSource {

    suspend fun create(address: Address): Response<Address>
    suspend fun findByUser(idUser: String): Response<List<Address>>

}