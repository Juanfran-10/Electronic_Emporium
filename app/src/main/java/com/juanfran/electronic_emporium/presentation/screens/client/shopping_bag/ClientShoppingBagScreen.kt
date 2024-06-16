package com.juanfran.electronic_emporium.presentation.screens.client.shopping_bag

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.screens.client.shopping_bag.components.ClientShoppingBagBottomBar
import com.juanfran.electronic_emporium.presentation.screens.client.shopping_bag.components.ClientShoppingBagContent

@Composable
fun ClientShoppingBagScreen(
    navController: NavHostController,
    vm: ClientShoppingBagViewModel = hiltViewModel()
) {
    vm.getShoppingBag()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Mi carrito",
                upAvailable = true,
                navController = navController
            )
        },
        bottomBar = {
            ClientShoppingBagBottomBar(navController)
        }

    ) { paddingValues ->
        ClientShoppingBagContent(paddingValues, vm.shoppingBag)
    }
}