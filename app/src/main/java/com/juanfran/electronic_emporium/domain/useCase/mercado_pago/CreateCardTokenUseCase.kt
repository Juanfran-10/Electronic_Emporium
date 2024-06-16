package com.juanfran.electronic_emporium.domain.useCase.mercado_pago

import com.juanfran.electronic_emporium.domain.model.CardTokenBody
import com.juanfran.electronic_emporium.domain.repository.MercadoPagoRepository

class CreateCardTokenUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(cardTokenBody: CardTokenBody) = repository.createCardToken(cardTokenBody)

}