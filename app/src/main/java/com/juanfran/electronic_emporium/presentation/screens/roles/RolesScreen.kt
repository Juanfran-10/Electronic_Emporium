package com.juanfran.electronic_emporium.presentation.screens.roles

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController) {
    Scaffold(
        topBar = { DefaultTopBar(title = "Selecciona un rol") }
    ) { paddingValues ->
        RolesContent(paddingValues, navController)
    }
}