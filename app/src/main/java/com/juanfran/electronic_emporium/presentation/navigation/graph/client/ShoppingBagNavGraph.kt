package com.juanfran.electronic_emporium.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.juanfran.electronic_emporium.presentation.navigation.Graph
import com.juanfran.electronic_emporium.presentation.navigation.screen.admin.AdminCategoryScreen
import com.juanfran.electronic_emporium.presentation.navigation.screen.client.ClientCategoryScreen
import com.juanfran.electronic_emporium.presentation.navigation.screen.client.ClientProductScreen
import com.juanfran.electronic_emporium.presentation.navigation.screen.client.ShoppingBagScreen
import com.juanfran.electronic_emporium.presentation.navigation.screen.roles.RolesScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.home.AdminHomeScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.product.create.AdminProductCreateScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.product.list.AdminProductListScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.product.update.AdminProductUpdateScreen
import com.juanfran.electronic_emporium.presentation.screens.client.address.create.ClientAddressCreateScreen
import com.juanfran.electronic_emporium.presentation.screens.client.address.list.ClientAddressListScreen
import com.juanfran.electronic_emporium.presentation.screens.client.home.ClientHomeScreen
import com.juanfran.electronic_emporium.presentation.screens.client.payments.form.ClientPaymentsFormScreen
import com.juanfran.electronic_emporium.presentation.screens.client.payments.installments.ClientPaymentsInstallmentsScreen
import com.juanfran.electronic_emporium.presentation.screens.client.payments.status.ClientPaymentsStatusScreen
import com.juanfran.electronic_emporium.presentation.screens.client.product.detail.ClientProductDetailScreen
import com.juanfran.electronic_emporium.presentation.screens.client.product.listByCategory.ClientProductByCategoryListScreen
import com.juanfran.electronic_emporium.presentation.screens.client.shopping_bag.ClientShoppingBagScreen
import com.juanfran.electronic_emporium.presentation.screens.roles.RolesScreen

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
            route = ShoppingBagScreen.PaymentsInstallments.route,
            arguments = listOf(navArgument("payment_form") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("payment_form")?.let {
                ClientPaymentsInstallmentsScreen(navController, it)
            }
        }
        composable(
            route = ShoppingBagScreen.PaymentsStatus.route,
            arguments = listOf(navArgument("payment_response") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("payment_response")?.let {
                ClientPaymentsStatusScreen(navController, it)
            }
        }
    }
}