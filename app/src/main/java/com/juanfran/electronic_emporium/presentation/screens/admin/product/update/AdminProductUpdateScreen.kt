package com.juanfran.electronic_emporium.presentation.screens.admin.product.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.screens.admin.product.create.components.AdminProductCreateContent
import com.juanfran.electronic_emporium.presentation.screens.admin.product.create.components.CreateProduct
import com.juanfran.electronic_emporium.presentation.screens.admin.product.update.components.AdminProductUpdateContent
import com.juanfran.electronic_emporium.presentation.screens.admin.product.update.components.UpdateProduct
import com.juanfran.electronic_emporium.presentation.ui.theme.Gray200

@Composable
fun AdminProductUpdateScreen(navController: NavHostController, productParam: String) {

    Log.d("AdminProductUpdateScreen", "Category: ${productParam}")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar producto",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray200
    ) {paddingValues ->
        AdminProductUpdateContent(paddingValues = paddingValues)
    }
    UpdateProduct()
}