package com.juanfran.electronic_emporium.domain.useCase.mercado_pago

import com.juanfran.electronic_emporium.domain.repository.MercadoPagoRepository

class GetInstallmentsUseCase(private val repository: MercadoPagoRepository) {

    operator fun invoke(firstSixDigits: Int, amount: Double) = repository.getInstallments(firstSixDigits, amount)

}