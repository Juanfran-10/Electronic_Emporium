package com.juanfran.electronic_emporium.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.juanfran.electronic_emporium.presentation.navigation.Graph
import com.juanfran.electronic_emporium.presentation.navigation.screen.admin.AdminOrderScreen
import com.juanfran.electronic_emporium.presentation.navigation.screen.client.ClientOrderScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.order.detail.AdminOrderDetailScreen
import com.juanfran.electronic_emporium.presentation.screens.client.order.detail.ClientOrderDetailScreen

fun NavGraphBuilder.ClientOrderNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_ORDER,
        startDestination = ClientOrderScreen.OrderDetail.route
    ) {

        composable(
            route = ClientOrderScreen.OrderDetail.route,
            arguments = listOf(navArgument("order") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("order")?.let {
                ClientOrderDetailScreen(navController, it)
            }
        }


    }
}