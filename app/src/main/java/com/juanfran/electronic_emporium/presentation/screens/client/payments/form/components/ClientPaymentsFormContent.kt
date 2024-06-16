package com.juanfran.electronic_emporium.presentation.screens.client.payments.form.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultButton
import com.juanfran.electronic_emporium.presentation.components.DefaultTextField
import com.juanfran.electronic_emporium.presentation.navigation.screen.client.ShoppingBagScreen
import com.juanfran.electronic_emporium.presentation.screens.client.payments.form.ClientPaymentsFormViewModel

@Composable
fun ClientPaymentsFormContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    vm: ClientPaymentsFormViewModel = hiltViewModel()
) {
    val state = vm.state
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)

    ) {
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.cardNumber,
            onValueChange = { vm.onCardNumberInput(it) },
            label = "Número de la tarjeta",
            icon = Icons.Default.Settings,
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = state.expirationYear,
                onValueChange = { vm.onYearExpirationInput(it) },
                label = "Año de expiración YYYY",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = state.expirationMonth,
                onValueChange = { vm.onMonthExpirationInput(it) },
                label = "Mes de expiración MM",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.name,
            onValueChange = { vm.onNameInput(it) },
            label = "Nombre del titular",
            icon = Icons.Default.Person
        )
        Spacer(modifier = Modifier.height(5.dp))
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.securityCode,
            onValueChange = { vm.onSecurityCodeInput(it) },
            label = "Código de seguridad",
            icon = Icons.Default.Lock
        )
        Spacer(modifier = Modifier.height(10.dp))
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.number,
            onValueChange = { vm.onIdentificationNumberInput(it) },
            label = "Número de identificación",
            icon = Icons.Default.List,
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.weight(1f))
        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Continuar",
            onClick = {
                navController.navigate(
                    route = ShoppingBagScreen.PaymentsStatus.route
                )
            }
        )
    }
}