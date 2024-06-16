package com.juanfran.electronic_emporium.domain.useCase.mercado_pago

import com.juanfran.electronic_emporium.domain.model.CardTokenBody
import com.juanfran.electronic_emporium.domain.model.PaymentBody
import com.juanfran.electronic_emporium.domain.repository.MercadoPagoRepository

class CreatePaymentUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(paymentBody: PaymentBody) = repository.createPayment(paymentBody)

}