package com.juanfran.electronic_emporium.presentation.screens.client.payments.status

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.screens.client.payments.status.components.ClientPaymentsStatusContent

@Composable
fun ClientPaymentsStatusScreen(navController: NavHostController, paymentResponseParam: String) {
    
    Scaffold() { paddingValues ->
        ClientPaymentsStatusContent(paddingValues = paddingValues, navController = navController)
    }
    
}