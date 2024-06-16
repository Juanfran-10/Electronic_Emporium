package com.juanfran.electronic_emporium.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.juanfran.electronic_emporium.presentation.navigation.Graph
import com.juanfran.electronic_emporium.presentation.navigation.graph.profile.ProfileNavGraph
import com.juanfran.electronic_emporium.presentation.navigation.screen.client.ClientScreen
import com.juanfran.electronic_emporium.presentation.screens.client.category.list.ClientCategoryListScreen
import com.juanfran.electronic_emporium.presentation.screens.client.order.list.ClientOrderListScreen
import com.juanfran.electronic_emporium.presentation.screens.client.product.list.ClientProductListScreen
import com.juanfran.electronic_emporium.presentation.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ) {

        composable(route = ClientScreen.ProductList.route) {
            ClientProductListScreen(navController)
        }

        composable(route = ClientScreen.CategoryList.route) {
            ClientCategoryListScreen(navController)
        }

        composable(route = ClientScreen.OrderList.route) {
            ClientOrderListScreen(navController)
        }

        composable(route = ClientScreen.Profile.route) {
            ProfileScreen(navController)
        }

        ProfileNavGraph(navController)
        ClientCategoryNavGraph(navController)
        ClientProductNavGraph(navController)
        ShoppingBagNavGraph(navController)
        ClientOrderNavGraph(navController)

    }
}