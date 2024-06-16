package com.juanfran.electronic_emporium.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.juanfran.electronic_emporium.presentation.navigation.Graph
import com.juanfran.electronic_emporium.presentation.navigation.screen.client.ShoppingBagScreen
import com.juanfran.electronic_emporium.presentation.screens.client.address.create.ClientAddressCreateScreen
import com.juanfran.electronic_emporium.presentation.screens.client.address.list.ClientAddressListScreen
import com.juanfran.electronic_emporium.presentation.screens.client.payments.form.ClientPaymentsFormScreen
import com.juanfran.electronic_emporium.presentation.screens.client.payments.status.ClientPaymentsStatusScreen
import com.juanfran.electronic_emporium.presentation.screens.client.shopping_bag.ClientShoppingBagScreen

fun NavGraphBuilder.ShoppingBagNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SHOPPING_BAG,
        startDestination = ShoppingBagScreen.ShoppingBag.route
    ) {
        composable(
            route = ShoppingBagScreen.ShoppingBag.route,
        ) {
            ClientShoppingBagScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.AddressList.route,
        ) {
            ClientAddressListScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.AddressCreate.route,
        ) {
            ClientAddressCreateScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.PaymentsForm.route,
        ) {
            ClientPaymentsFormScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.PaymentsStatus.route
        ) {
            ClientPaymentsStatusScreen()
        }
    }
}