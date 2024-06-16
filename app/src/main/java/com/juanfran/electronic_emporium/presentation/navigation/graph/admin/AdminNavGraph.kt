package com.juanfran.electronic_emporium.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.juanfran.electronic_emporium.presentation.navigation.Graph
import com.juanfran.electronic_emporium.presentation.navigation.graph.profile.ProfileNavGraph
import com.juanfran.electronic_emporium.presentation.navigation.screen.admin.AdminScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.order.list.AdminOrderListScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.product.list.AdminProductListScreen
import com.juanfran.electronic_emporium.presentation.screens.profile.info.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.CategoryList.route
    ) {
        composable(route = AdminScreen.CategoryList.route) {
            AdminCategoryListScreen(navController)
        }

        composable(route = AdminScreen.OrderList.route) {
            AdminOrderListScreen(navController)
        }

        composable(route = AdminScreen.Profile.route) {
            ProfileScreen(navController)
        }
        ProfileNavGraph(navController)
        AdminCategoryNavGraph(navController)
        AdminOrderNavGraph(navController)
    }
}