package com.juanfran.electronic_emporium.presentation.screens.client.shopping_bag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultButton
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.navigation.screen.client.ShoppingBagScreen
import com.juanfran.electronic_emporium.presentation.screens.client.shopping_bag.components.ClientShoppingBagBottomBar
import com.juanfran.electronic_emporium.presentation.screens.client.shopping_bag.components.ClientShoppingBagContent
import com.juanfran.electronic_emporium.presentation.ui.theme.Gray100

@Composable
fun ClientShoppingBagScreen(navController: NavHostController, vm: ClientShoppingBagViewModel = hiltViewModel()) {

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