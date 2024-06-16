package com.juanfran.electronic_emporium.presentation.screens.client.category.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.screens.client.category.list.components.ClientCategoryListContent
import com.juanfran.electronic_emporium.presentation.screens.client.category.list.components.GetCategories
import com.juanfran.electronic_emporium.presentation.screens.profile.info.components.ProfileContent

@Composable
fun ClientCategoryListScreen(navController: NavHostController) {
    Scaffold() { paddingValues ->
        GetCategories(paddingValues, navController)
    }
}