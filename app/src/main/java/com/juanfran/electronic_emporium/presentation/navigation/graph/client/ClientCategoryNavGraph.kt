package com.juanfran.electronic_emporium.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.juanfran.electronic_emporium.presentation.navigation.Graph
import com.juanfran.electronic_emporium.presentation.navigation.screen.admin.AdminCategoryScreen
import com.juanfran.electronic_emporium.presentation.navigation.screen.client.ClientCategoryScreen
import com.juanfran.electronic_emporium.presentation.navigation.screen.client.ClientProductScreen
import com.juanfran.electronic_emporium.presentation.navigation.screen.roles.RolesScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.home.AdminHomeScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.product.create.AdminProductCreateScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.product.list.AdminProductListScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.product.update.AdminProductUpdateScreen
import com.juanfran.electronic_emporium.presentation.screens.client.home.ClientHomeScreen
import com.juanfran.electronic_emporium.presentation.screens.client.product.detail.ClientProductDetailScreen
import com.juanfran.electronic_emporium.presentation.screens.client.product.listByCategory.ClientProductByCategoryListScreen
import com.juanfran.electronic_emporium.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.ClientCategoryNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_CATEGORY,
        startDestination = ClientCategoryScreen.ProductList.route
    ) {
        composable(
            route = ClientCategoryScreen.ProductList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
                ClientProductByCategoryListScreen(navController, it)
            }
        }

        composable(
            route = ClientCategoryScreen.ProductDetail.route,
            arguments = listOf(navArgument("product") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("product")?.let {
                ClientProductDetailScreen(navController, it)
            }
        }
    }
}