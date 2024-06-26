package com.juanfran.electronic_emporium.presentation.screens.client.payments.form

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanfran.electronic_emporium.domain.model.IdentificationType
import com.juanfran.electronic_emporium.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientPaymentsFormViewModel @Inject constructor() :
    ViewModel() {
    var state by mutableStateOf(ClientPaymentsFormState())
        private set

    var identificationTypesResponse by mutableStateOf<Resource<List<IdentificationType>>?>(null)
        private set

    fun onCardNumberInput(input: String) {
        state = state.copy(cardNumber = input)
    }

    fun onYearExpirationInput(input: String) {
        state = state.copy(expirationYear = input)
    }

    fun onMonthExpirationInput(input: String) {
        state = state.copy(expirationMonth = input)
    }

    fun onSecurityCodeInput(input: String) {
        state = state.copy(securityCode = input)
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onIdentificationTypeInput(input: String) {
        state = state.copy(type = input)
    }

    fun onIdentificationNumberInput(input: String) {
        state = state.copy(number = input)
    }
}