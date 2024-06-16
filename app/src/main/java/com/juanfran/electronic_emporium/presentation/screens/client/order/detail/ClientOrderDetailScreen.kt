package com.juanfran.electronic_emporium.presentation.screens.client.order.detail

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.screens.client.order.detail.ClientOrderDetailViewModel
import com.juanfran.electronic_emporium.presentation.screens.admin.order.detail.components.AdminOrderDetailContent
import com.juanfran.electronic_emporium.presentation.screens.admin.order.detail.components.UpdateStatusOrder
import com.juanfran.electronic_emporium.presentation.screens.client.order.detail.components.ClientOrderDetailContent

@Composable
fun ClientOrderDetailScreen(navController: NavHostController, orderParam: String, vm: ClientOrderDetailViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Detalle de la orden",
                navController = navController,
                upAvailable = true
            )
        }
    ) { paddingValues ->  
        ClientOrderDetailContent(paddingValues, vm.order)
    }
    UpdateStatusOrder()
    
}