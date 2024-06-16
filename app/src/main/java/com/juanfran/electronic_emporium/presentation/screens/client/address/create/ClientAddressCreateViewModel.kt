package com.juanfran.electronic_emporium.presentation.screens.client.address.create

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanfran.electronic_emporium.domain.model.Address
import com.juanfran.electronic_emporium.domain.useCase.address.AddressUseCase
import com.juanfran.electronic_emporium.domain.useCase.auth.AuthUseCase
import com.juanfran.electronic_emporium.domain.util.Resource
import com.juanfran.electronic_emporium.presentation.screens.client.address.create.mapper.toAddress
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientAddressCreateViewModel @Inject constructor(
    private val addressUseCase: AddressUseCase,
    private val authUseCase: AuthUseCase
): ViewModel() {

    var state by mutableStateOf(ClientAddressCreateState())
        private set

    var addressResponse by mutableStateOf<Resource<Address>?>(null)
        private set

    fun getSessionData() = viewModelScope.launch {
        val user = authUseCase.getSessionData().first().user
        state = state.copy(idUser = user?.id ?: "")
    }

    fun createAddress() = viewModelScope.launch {
        addressResponse = Resource.Loading
        val result = addressUseCase.createAddress(state.toAddress())
        addressResponse = result
    }

    fun onAddressInput(address: String) {
        state = state.copy(address = address)
    }

    fun onNeighborhoodInput(neighborhood: String) {
        state = state.copy(neighborhood = neighborhood)
    }

    fun clearForm() {
        state = state.copy(
            address = "",
            neighborhood = ""
        )
        addressResponse = null
    }
}