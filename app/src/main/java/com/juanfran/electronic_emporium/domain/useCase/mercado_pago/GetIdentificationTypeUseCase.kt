package com.juanfran.electronic_emporium.domain.useCase.mercado_pago

import com.juanfran.electronic_emporium.domain.repository.MercadoPagoRepository

class GetIdentificationTypeUseCase(private val repository: MercadoPagoRepository) {

    operator fun invoke() = repository.getIdentificationTypes()

}