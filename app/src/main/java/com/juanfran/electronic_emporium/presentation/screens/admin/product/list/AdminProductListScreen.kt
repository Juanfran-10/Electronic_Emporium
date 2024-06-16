package com.juanfran.electronic_emporium.presentation.screens.admin.product.list

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.domain.model.Category
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.navigation.Graph
import com.juanfran.electronic_emporium.presentation.navigation.screen.admin.AdminCategoryScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.product.list.components.AdminProductListContent
import com.juanfran.electronic_emporium.presentation.screens.admin.product.list.components.DeleteProduct
import com.juanfran.electronic_emporium.presentation.screens.admin.product.list.components.GetProducts
import com.juanfran.electronic_emporium.presentation.screens.client.product.list.components.ClientProductListContent

@Composable
fun AdminProductListScreen(navController: NavHostController, categoryParam: String) {
    val categoryParse = Category.fromJson(categoryParam).toJson()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Productos",
                navController = navController,
                upAvailable = true
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = {
                    navController.navigate(
                        route = AdminCategoryScreen.ProductCreate.passCategory(
                            categoryParse
                        )
                    )
                },
                backgroundColor = Color.DarkGray
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->
        GetProducts(navController = navController, paddingValues = paddingValues)
    }
    DeleteProduct()
}