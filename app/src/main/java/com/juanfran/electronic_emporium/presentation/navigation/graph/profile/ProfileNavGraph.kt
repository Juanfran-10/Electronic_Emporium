package com.juanfran.electronic_emporium.presentation.navigation.graph.profile

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.juanfran.electronic_emporium.presentation.navigation.Graph
import com.juanfran.electronic_emporium.presentation.navigation.screen.profile.ProfileScreen
import com.juanfran.electronic_emporium.presentation.navigation.screen.roles.RolesScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.home.AdminHomeScreen
import com.juanfran.electronic_emporium.presentation.screens.client.home.ClientHomeScreen
import com.juanfran.electronic_emporium.presentation.screens.profile.update.ProfileUpdateScreen
import com.juanfran.electronic_emporium.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE + "/{user}",
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {

        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileUpdateScreen(navController, userParam = it)
            }
        }

    }
}