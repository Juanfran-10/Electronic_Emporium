package com.juanfran.electronic_emporium.presentation.screens.admin.category.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.juanfran.electronic_emporium.presentation.screens.admin.category.create.components.CreateCategory
import com.juanfran.electronic_emporium.presentation.screens.admin.category.update.components.AdminCategoryUpdateContent
import com.juanfran.electronic_emporium.presentation.screens.admin.category.update.components.UpdateCategory
import com.juanfran.electronic_emporium.presentation.ui.theme.Gray200

@Composable
fun AdminCategoryUpdateScreen(navController: NavHostController, categoryParam: String) {
    Log.d("AdminCategoryUpdateScreen", "Data: $categoryParam")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar Categoría",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray200
    ) { paddingValues ->
        AdminCategoryUpdateContent(paddingValues = paddingValues)
    }
    UpdateCategory()
}