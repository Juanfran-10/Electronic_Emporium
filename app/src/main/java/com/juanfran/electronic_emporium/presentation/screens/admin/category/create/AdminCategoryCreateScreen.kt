package com.juanfran.electronic_emporium.presentation.screens.admin.category.create

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.juanfran.electronic_emporium.presentation.screens.admin.category.create.components.CreateCategory
import com.juanfran.electronic_emporium.presentation.ui.theme.Gray100

@Composable
fun AdminCategoryCreateScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva Categoria",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray100
    ) { paddingValues ->
        AdminCategoryCreateContent(paddingValues = paddingValues)
    }
    CreateCategory()

}