package com.juanfran.electronic_emporium.presentation.screens.admin.product.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.domain.model.Product
import com.juanfran.electronic_emporium.presentation.screens.admin.product.list.AdminProductListViewModel

@Composable
fun AdminProductListContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    products: List<Product>
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        items(items = products) { product ->
            AdminProductListItem(navController, product)
        }
    }
}