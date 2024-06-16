package com.juanfran.electronic_emporium.presentation.screens.client.payments.installments.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.domain.util.Resource
import com.juanfran.electronic_emporium.presentation.components.ProgressBar
import com.juanfran.electronic_emporium.presentation.screens.client.payments.form.ClientPaymentsFormViewModel
import com.juanfran.electronic_emporium.presentation.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel

@Composable
fun GetInstallments(paddingValues: PaddingValues, vm: ClientPaymentsInstallmentsViewModel = hiltViewModel()) {
    when(val response = vm.installmentsResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
           ClientPaymentsInstallmentsContent(paddingValues,  installments = response.data.payerCosts)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}