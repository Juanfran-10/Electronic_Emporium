package com.juanfran.electronic_emporium.presentation.screens.client.payments.form

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.screens.client.payments.form.components.ClientPaymentsFormContent
import com.juanfran.electronic_emporium.presentation.screens.client.payments.form.components.GetIdentificationTypes

@Composable
fun ClientPaymentsFormScreen(navController: NavHostController, vm: ClientPaymentsFormViewModel = hiltViewModel()) {

    vm.getIdentificationTypes()
//    vm.getInstallments(525413,100000.0 )

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Formulario de pago",
                upAvailable = true,
                navController = navController
            )
        }
    ) { paddingValues ->
        GetIdentificationTypes(paddingValues = paddingValues, navController = navController)
    }
    
}