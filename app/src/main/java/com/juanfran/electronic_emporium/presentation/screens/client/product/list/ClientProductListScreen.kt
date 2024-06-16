package com.juanfran.electronic_emporium.presentation.screens.client.product.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultSearchView
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.screens.client.category.list.components.ClientCategoryListContent
import com.juanfran.electronic_emporium.presentation.screens.client.product.list.ClientProductListViewModel
import com.juanfran.electronic_emporium.presentation.screens.client.product.list.components.ClientProductListContent
import com.juanfran.electronic_emporium.presentation.screens.client.product.list.components.GetProducts

@Composable
fun ClientProductListScreen(
    navController: NavHostController,
    vm: ClientProductListViewModel = hiltViewModel()
) {
    vm.getProducts()

    Scaffold(
        topBar = {
            DefaultSearchView(
                value = vm.search,
                onValueChange = { text ->
                    vm.onSearchInput(text)
                },
                navController = navController,
                onClick = {
                    if (vm.search.isNotBlank()) {
                        vm.getProductsByName(vm.search)
                    }
                }
            )
        }
    ) { paddingValues ->
        GetProducts(navController = navController, paddingValues = paddingValues)
    }
}