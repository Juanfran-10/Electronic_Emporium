package com.juanfran.electronic_emporium.presentation.screens.client.payments.status

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.juanfran.electronic_emporium.domain.useCase.shopping_bag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClientPaymentsStatusViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val data = savedStateHandle.get<String>("payment_response")
}