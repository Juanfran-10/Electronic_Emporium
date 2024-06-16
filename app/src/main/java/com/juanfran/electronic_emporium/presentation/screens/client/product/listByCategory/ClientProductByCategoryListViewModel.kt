package com.juanfran.electronic_emporium.presentation.screens.client.product.listByCategory

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanfran.electronic_emporium.domain.model.Category
import com.juanfran.electronic_emporium.domain.model.Product
import com.juanfran.electronic_emporium.domain.useCase.products.ProductsUseCase
import com.juanfran.electronic_emporium.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductByCategoryListViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    var data = savedStateHandle.get<String>("category")
    var category = Category.fromJson(data!!)

    var productsResponse by mutableStateOf<Resource<List<Product>>?>(null)
        private set

    var productDeleteResponse by mutableStateOf<Resource<Unit>?>(null)
        private set

    init {
        getProducts()
    }

    fun getProducts() = viewModelScope.launch {
        productsResponse = Resource.Loading
        productsUseCase.findByCategory(category.id!!).collect() {
            productsResponse = it
        }
    }
}