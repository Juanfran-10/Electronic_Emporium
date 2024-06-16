package com.juanfran.electronic_emporium.presentation.screens.client.payments.form

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.screens.client.payments.form.components.ClientPaymentsFormContent

@Composable
fun ClientPaymentsFormScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Formulario de pago",
                upAvailable = true,
                navController = navController
            )
        }
    ) { paddingValues ->
        ClientPaymentsFormContent(
            paddingValues = paddingValues,
            navController = navController
        )
    }
}